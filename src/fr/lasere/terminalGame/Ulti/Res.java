package fr.lasere.terminalGame.Ulti;

import java.util.Random;

import fr.lasere.terminalGame.Player.Player;

public class Res {
	
	private int regenaret = new Random().nextInt(50);
	
	public void Regenaret(Player player) {
		while (regenaret < 25) {
			regenaret = new Random().nextInt(50);
		}
		player.addHealth(regenaret);
		System.out.println("you restored: " + regenaret + " life point");
	}
}
