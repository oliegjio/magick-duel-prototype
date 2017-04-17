package com.olegsorokin.general;

import com.olegsorokin.general.Skill;

public class Player {

	private String name;
	private int health;
	private int mana;
	private Skill[] skills;
	
	public Player(String name, int health, int mana) {
		this.name = name;
		this.health = health;
		this.mana = mana;
	}
	
	public String getName() { return this.name; }
	public int getHealth() { return this.health; }
	public int getMana() { return this.mana; }
	public void setHealth(int health) { this.health = health; }
	public void setMana(int mana) { this.mana = mana; }
	public Skill[] getSkills() { return this.skills; }
	public void setSkills(Skill[] skills) { this.skills = skills; }
	
}
