package com.codechef.pankaj;

import java.util.Scanner;

public class ChefCinema {
	//Chef Goes to the Cinema
	//https://www.codechef.com/viewsolution/17906018
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
