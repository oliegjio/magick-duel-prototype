package com.olegsorokin.general;

import java.util.Random;
import java.util.Vector;
import java.util.Scanner;

import com.olegsorokin.general.Skill;
import com.olegsorokin.general.Player;
import com.olegsorokin.general.Helpers;

public class Game {

	private Player redPlayer;
	private Player bluePlayer;
	private Player activePlayer;
	private Player otherPlayer;
	private static boolean isFirstTurn = true;
	private int turn;
	
	public Game(Scanner scanner) {
		while (true) {
			// Initialize the game.
			if (isFirstTurn) { init(); }
			
			printStats();
			
			if (isFirstTurn) {
				// Randomly roll a turn.
				turn = new Random().nextInt(2) + 1;
				
				// Picks an active player.
				switch (turn) {
				case 1:
					activePlayer = redPlayer;
					otherPlayer = bluePlayer;
					break;
				case 2:
					activePlayer = bluePlayer;
					otherPlayer = redPlayer;
					break;
				}
				
				isFirstTurn = false;
			}
			
			System.out.println("\n");
			if (turn == 1) {
				System.out.println("Red Player move!");
			} else {
				System.out.println("Blue Player move!");
			}
			
			// Cache players's skills.
			Skill[] activePlayerSkills = activePlayer.getSkills();
			Skill[] otherPlayerSkills = otherPlayer.getSkills();
			
			// Gets skill number from the user.
			int input =  scanner.nextInt();
			
			// Exit the game if the user types "0".
			if (input == 0) {
				break;
			}
			
			// Is choosen skill number correct?
			if (input < 0 || input > activePlayerSkills.length) {
				Helpers.clear();
				printStats();
				System.out.println("\nWrong skill number");
				continue;
			}
			
			// Active player picks a skill.
			// Inactive player gets damage of that skill.
			otherPlayer.damage(activePlayerSkills[input - 1].rollDamage());
			
			// Switch turn.
			if (turn == 1) { turn = 2; } else { turn = 1; }
			
			// Switch active player.
			if (activePlayer == redPlayer) { 
				activePlayer = bluePlayer; otherPlayer = redPlayer;
			} else {
				activePlayer = redPlayer; otherPlayer = bluePlayer;
			}
			
			// Clear the screen: next turn.
			Helpers.clear();
		}
	}
	
	// Initializes starting values.
	private void init() {
		redPlayer = new Player("Red Player", 100, 1);
		bluePlayer = new Player("Blue Player", 100, 1);
		
		Skill[] redPlayerSkills = new Skill[2];
		Skill[] bluePlayerSkills = new Skill[2];
		
		Vector<Integer> fireBallDamage = new Vector<Integer>(2);
		fireBallDamage.add(5);
		fireBallDamage.add(10);
		redPlayerSkills[0] = new Skill("Fireboll", 1, fireBallDamage);
		
		Vector<Integer> frostBoltDamage = new Vector<Integer>(2);
		frostBoltDamage.add(10);
		frostBoltDamage.add(20);
		redPlayerSkills[1] = new Skill("Frostbolt", 2, frostBoltDamage);
		
		redPlayer.setSkills(redPlayerSkills);
		
		Vector<Integer> pewPewDamage = new Vector<Integer>(2);
		pewPewDamage.add(6);
		pewPewDamage.add(13);
		bluePlayerSkills[0] = new Skill("Pew-pew", 1, pewPewDamage);
		
		Vector<Integer> arcaneBlastDamage = new Vector<Integer>(2);
		arcaneBlastDamage.add(0);
		arcaneBlastDamage.add(30);
		bluePlayerSkills[1] = new Skill("Arcane blast", 2, arcaneBlastDamage);
		
		bluePlayer.setSkills(bluePlayerSkills);
	}
	
	// Prints players' names, spells, HPs, MPs etc...
	private void printStats() {
		Skill[] redPlayerSkills = redPlayer.getSkills();
		Skill[] bluePlayerSkills = bluePlayer.getSkills();
		
		System.out.println("----- " + this.redPlayer.getName() + ": -----");
		System.out.println("HP: " + this.redPlayer.getHealth());
		System.out.println("Mana: " + this.redPlayer.getMana());
		System.out.println(">> Skills:");
		
		for (int i = 0; i <= redPlayerSkills.length - 1; i++) {
			System.out.println(redPlayerSkills[i].getName());
		}
		
		System.out.println("\n");
		
		System.out.println("----- " + this.bluePlayer.getName() + ": -----");
		System.out.println("HP: " + this.bluePlayer.getHealth());
		System.out.println("Mana: " + this.bluePlayer.getMana());
		System.out.println(">> Skills:");
		
		for (int i = 0; i <= bluePlayerSkills.length - 1; i++) {
			System.out.println(bluePlayerSkills[i].getName());
		}
	}
	
}
