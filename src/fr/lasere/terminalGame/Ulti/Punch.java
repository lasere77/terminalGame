package fr.lasere.terminalGame.Ulti;

import java.util.Random;

import fr.lasere.terminalGame.Player.Player;

public class Punch {
	
	private int damage = new Random().nextInt(100);
	
	public void Punche(Player player) {
		while (damage < 50) {
			damage = new Random().nextInt(100);
		}
		player.damage(damage);
		System.out.println("you have inflicted:" + damage + " point of damage to the enemy");
	}
}
