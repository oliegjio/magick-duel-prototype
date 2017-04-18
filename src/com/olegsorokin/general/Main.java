package com.olegsorokin.general;

import java.util.Scanner;

import com.olegsorokin.general.Game;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		new Game(scanner);
		
		scanner.close();
	}
	
}
