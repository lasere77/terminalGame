package fr.lasere.terminalGame;

import java.util.Random;
import java.util.Scanner;

import fr.lasere.terminalGame.Player.Player;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	private static boolean running = true;
	private static boolean your_turn = true;

	private static Random rand = new Random();
	
	public static void main(String[] args) {
		//create player and enemy
		Player player = new Player("lasere", 50, 10, 25);
		Player enemy = new Player("enemy", 50, 15, 0);
		
		while (running) {
			//set nb damage
			int player_damage = rand.nextInt(10);
			int enemy_damage = rand.nextInt(15);
			
			//check if win
			if(player.getHealth() <= 0) {
				System.out.println("fin de la patie vous avez perdu....");
				running = false;
			}
			if(enemy.getHealth() <= 0) {
				System.out.println("fin de la patie vous avez gagné!!!!!");
				running = false;
			}
			
			if(your_turn && running) {
				System.out.println("que voulez vous faire ??? attacké = 1 ou posiont = 2 ?");
				int choose = scan.nextInt();
				if(choose == 1) {
					enemy.damage(player_damage);
					System.out.println("lénamie a eu : " + player_damage + " de  dégat");
					System.out.println("il luis reste : " + enemy.getHealth());
					your_turn = false;
				}else if (choose == 2) {
					
					your_turn = false;
				}else {
					System.out.println("vouttre tour a été passé ...");
					your_turn = false;
				}
			}else if (!your_turn && running) {
				System.out.println("c est le tour du mob");
				player.damage(enemy_damage);
				if(player.getHealth() < 0) {
					player.setHealth(0);
				}
				System.out.println("l'énémie vous a infligier : " + enemy_damage + " de d'égat");
				System.out.println("votre vie est de : " + player.getHealth());
				your_turn = true;
			}
		}
	}
}
