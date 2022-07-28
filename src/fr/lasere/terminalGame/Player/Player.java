package fr.lasere.terminalGame.Player;


public class Player {
		
	private String name;
	private int health;
	private int shild;
	
	public Player(String name, int health, int shild) {
		this.name = name;
		this.health = health;
		this.shild = shild;
	}

	
	
	public void damage(int damage) {
		if(this.shild > 0) {
			this.shild -= damage;
		}else {
			this.health -= damage;
		}
		
		if(this.health < 0) {
			this.health = 0;
		}
		if(this.shild < 0) {
			shildDamage();
		}
	}
	public void shildDamage() {
		this.health += this.shild;
		this.shild = 0;
	}
	
	
	public String getName() {
		return name;
	}


	public int getHealth() {
		return health;
	}
	public void addHealth(int health) {
		this.health += health;
	}


	public int getShild() {
		return shild;
	}
}
