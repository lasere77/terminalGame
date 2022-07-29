package fr.lasere.terminalGame;

import java.util.Random;
import java.util.Scanner;

import fr.lasere.terminalGame.Player.Player;
import fr.lasere.terminalGame.Potion.PotionEffect;
import fr.lasere.terminalGame.Ulti.Punch;
import fr.lasere.terminalGame.Ulti.Res;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	private static boolean running = true;
	private static boolean your_turn = true;
	private static int turn = 0;
	private static int mana = 0;
	
	
	private static Punch punch = new Punch();
	private static Res res = new Res();

	private static Random random = new Random();
	
	public static void main(String[] args) {
		//create player and enemy
		Player player = new Player("lasere77", 50, 25, 3);
		Player enemy = new Player("enemy", 500, 0, 0);

		while (running) {
			//set numbers damage
			int player_damage = random.nextInt(10);
			int enemy_damage = random.nextInt(15);
			
			//check if win or lost
			if(player.getHealth() <= 0) {
				System.out.println("end of the game you have lose..." + enemy.getName() + " to win");
				running = false;
			}
			if(enemy.getHealth() <= 0) {
				System.out.println("end of the game you have win!!! gg " + player.getName() + "turn" + turn);
				running = false;
			}
			
			if(your_turn && running) {
				System.out.println("\n--------------------------------------------------------------");
				System.out.println("what do you want to do ? attacked = 1 or potion = 2? or Ulti = 3 only if you have 3 mana");
				int choose = scan.nextInt();
				if(choose == 1) {
					enemy.damage(player_damage);
					System.out.println("the enamie had: " + player_damage + " point of damage");
					System.out.println("he remains: " + enemy.getHealth());
					your_turn = false;
				}else if (choose == 2) {
					PotionEffect.potion(player);
					your_turn = false;
				}else if (choose == 3 && mana >= 3) {
					System.out.println("what ult to use ? 1 = Punch 2 = Res");
					int chooseUlti = scan.nextInt();
					if(chooseUlti == 1) {
						punch.Punche(enemy);
						System.out.println("he remains: " + enemy.getHealth());
						your_turn = false;
						mana = 0;
					}else if (chooseUlti == 2) {
						res.Regenaret(player);
						your_turn = false;
						mana = 0;
					}else if (mana < 3) {
						System.out.println("you don't have enough mana to use an Ulti");
					}else {
						System.out.println("your turn has passed ...");
						your_turn = false;
					}
				}else {
					System.out.println("your turn has passed ...");
					your_turn = false;
				}
			//turn of mob
			}else if (!your_turn && running) {
				System.out.println("it's the turn of the mob \n");
				player.damage(enemy_damage);
				

				System.out.println("the enemy has inflicted on you: " + enemy_damage + " point of damage");
				System.out.println("your life is: " + player.getHealth());
				System.out.println("your shild is: " + player.getShild());
				System.out.println("you have:" + mana + " mana");
				turn++;
				mana++;
				your_turn = true;
			}
		}
	}
	

}
