package com.codechef.pankajmahato.cook92b;

import java.util.Scanner;

public class ChefCinema {
	//Chef Goes to the Cinema
	// https://www.codechef.com/COOK92B/problems/CO92SUBW
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int x = in.nextInt();
			int n = (int) Math.floor(Math.sqrt(2 * x));
			if (Math.abs(n * (n + 1) / 2 - x) < Math.abs(n * (n - 1) / 2 - x))
				System.out.println(Math.abs(n * (n + 1) / 2 - x) + (n - 1) + 1);
			else
				System.out.println(Math.abs(n * (n + 1) / 2 - x) + (n - 1));
		}
	}
}
