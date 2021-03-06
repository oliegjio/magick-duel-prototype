package com.olegsorokin.general;

import java.util.Random;
import java.util.Vector;

public class Skill {

	private String name;
	private int manaCost;
	private Vector<Integer> damage;
	
	public Skill(String name, int manaCost, Vector<Integer> damage) {
		this.name = name;
		this.manaCost = manaCost;
		this.damage = damage;
	}
	
	public int rollDamage() {
		return new Random().nextInt(this.damage.get(1)) + this.damage.get(0);
	}
	
	public String getName() { return this.name; }
	public int getManaCost() { return this.manaCost; }
	public Vector<Integer> getDamage() { return this.damage; }
	
}
