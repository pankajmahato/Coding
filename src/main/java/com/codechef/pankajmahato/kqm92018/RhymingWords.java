package com.codechef.pankajmahato.kqm92018;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RhymingWords {
	// Rhyming Words (keteki)
	// https://www.codechef.com/KQM92018/problems/QM9A
	private static InputStream stream;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));





	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			//System.out.println(n+ " ");
			//String str  =  sc.next();
			//System.out.println(str+ " ");
			String[] splited = new String[n];
			int a = 0, e = 0, u = 0, ii = 0, o = 0;
			for (int j = 0; j < n; j++) {
				try {
					splited[j] = sc.next();
					char[] c = splited[j].toCharArray();
					for (int k = c.length - 1; k >= 0; k--) {
						if (c[k] == 'a') {
							a++;
							break;
						}
						if (c[k] == 'e') {
							e++;
							break;
						}
						if (c[k] == 'i') {
							ii++;
							break;
						}
						if (c[k] == 'u') {
							u++;
							break;
						}
						if (c[k] == 'o') {
							o++;
							break;
						}
					}


				} catch (Exception ee) {

				}

			}
			int count = 0;
			if (a > 1) {
				count = count + a;
			}
			if (e > 1) {
				count = count + e;
			}
			if (ii > 1) {
				count = count + ii;
			}
			if (u > 1) {
				count = count + u;
			}
			if (o > 1) {
				count = count + o;
			}
			System.out.println(count);
		}

	}





	private static int indexLastVowel(String s) {
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				return i;
			default:
				break;
			}
		}

		return -1;
	}





	public static void InputReader(InputStream stream1) {
		stream = stream1;
	}





	private static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}





	private static boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}





	private static int read() {
		if (numChars == -1) {
			throw new InputMismatchException();
		}
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0) {
				return -1;
			}
		}
		return buf[curChar++];
	}





	private static int nI() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}





	private static long nL() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}





	private static String nS() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}





	private static String nLi() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}





	private static boolean isSpaceChar(int c) {
		if (filter != null) {
			return filter.isSpaceChar(c);
		}
		return isWhitespace(c);
	}

	private interface SpaceCharFilter {

		public boolean isSpaceChar(int ch);
	}
}
