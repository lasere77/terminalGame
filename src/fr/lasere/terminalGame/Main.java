package fr.lasere.terminalGame;

import java.util.Random;
import java.util.Scanner;

import fr.lasere.terminalGame.Player.Player;
import fr.lasere.terminalGame.Potion.PotionEffect;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	private static boolean running = true;
	private static boolean your_turn = true;

	private static Random random = new Random();
	
	public static void main(String[] args) {
		//create player and enemy
		Player player = new Player("lasere", 50, 25);
		Player enemy = new Player("enemy", 50, 0);

		while (running) {
			//set nunbers damage
			int player_damage = random.nextInt(10);
			int enemy_damage = random.nextInt(15);
			
			//check if win or lost
			if(player.getHealth() <= 0) {
				System.out.println("end of the game you have lose...");
				running = false;
			}
			if(enemy.getHealth() <= 0) {
				System.out.println("end of the game you have win!!!");
				running = false;
			}
			
			if(your_turn && running) {
				System.out.println("what do you want to do ? attacked = 1 or potion = 2?");
				int choose = scan.nextInt();
				if(choose == 1) {
					enemy.damage(player_damage);
					System.out.println("the enamie had: " + player_damage + " point of damage");
					System.out.println("he remains: " + enemy.getHealth());
					your_turn = false;
				}else if (choose == 2) {
					PotionEffect.potion(player);
					your_turn = false;
				}else {
					System.out.println("your turn has passed ...");
					your_turn = false;
				}
			//turn of mob
			}else if (!your_turn && running) {
				System.out.println("it's the turn of the mob");
				player.damage(enemy_damage);
				

				System.out.println("the enemy has inflicted on you: " + enemy_damage + " point of damage");
				System.out.println("your life is: " + player.getHealth());
				System.out.println("your shild is: " + player.getShild());
				your_turn = true;
			}
		}
	}
	

}
