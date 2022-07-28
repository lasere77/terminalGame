package fr.lasere.terminalGame.Player;

import java.util.Random;

public class Player {
	
	private Random rand = new Random();
	
	private String name;
	private int health;
	private int damage;
	private int shild;
	
	public Player(String name, int health, int damage, int shild) {
		this.name = name;
		this.health = health;
		this.damage = rand.nextInt(damage);
		this.shild = shild;
	}

	
	
	public void damage(int damage) {
		this.health -= damage;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}



	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}



	public int getShild() {
		return shild;
	}



	public void setShild(int shild) {
		this.shild = shild;
	}
}
