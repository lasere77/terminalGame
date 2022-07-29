package fr.lasere.terminalGame.Potion;

import java.util.Random;

import fr.lasere.terminalGame.Player.Player;

public class PotionEffect {
	
	private static Random random = new Random();
	
	
	
	public static void potion(Player player) {
		int number_potions = player.getPotion();
		if(player.getHealth() > 100) {
			System.out.println("you can't use your potion");
		}
		if(number_potions >= 0) {
			int rand = random.nextInt(50);
			player.addHealth(rand);
			System.out.println("the postuion has restored you: " + rand + " life points.");
			System.out.println("you still have: " + number_potions + " potion.");
			player.delPotion();
		}else {
			System.out.println("you have used all potion calves...");
		}
	}
}
