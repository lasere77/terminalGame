package fr.lasere.terminalGame.Potion;

import java.util.Random;

import fr.lasere.terminalGame.Player.Player;

public class PotionEffect {
	
	private static Random random = new Random();
	private static int number_potions = 3;
	
	
	public static void potion(Player player) {
		if(player.getHealth() > 75) {
			System.out.println("you can't use your potion");
		}
		if(number_potions >= 0) {
			int rand = random.nextInt(50);
			player.addHealth(rand);
			System.out.println("the postuion has restored you: " + rand + " life points.");
			System.out.println("you still have: " + number_potions + " potion.");
			number_potions--;
		}else {
			System.out.println("you have used all potion calves...");
		}
	}
}
