package com.olegsorokin.general;

import java.util.Random;
import java.util.Vector;

import com.olegsorokin.general.Skill;
import com.olegsorokin.general.Player;

public class Game {

	private Player redPlayer;
	private Player bluePlayer;
	
	public Game() {
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
		
		int turn = new Random().nextInt(2) + 1;
		
		switch(turn) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		}
		
	}
	
}
