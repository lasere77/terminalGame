package fr.lasere.terminalGame.Ulti;

import java.util.Random;

import fr.lasere.terminalGame.Player.Player;

public class Mas {
	
	private int damage = new Random().nextInt(50);
	private int addHp = new Random().nextInt(25);
	
	public void Massage(Player player) {
		while (addHp < 10) {
			addHp = new Random().nextInt(25);
		}
		player.damage(damage);
		System.out.println("you have inflicted:" + damage + " point of damage to the enemy");
		player.addHealth(addHp);
		System.out.println("and you regained:" + addHp + "hit point");
	}
	
}
