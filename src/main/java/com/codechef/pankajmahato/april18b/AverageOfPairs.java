package com.codechef.pankajmahato.april18b;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class AverageOfPairs {

	//Average of Pairs
	//https://www.codechef.com/APRIL18B/problems/AVGPR

	private static InputStream stream;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));





	public static void main(String[] args) throws IOException {
		InputReader(System.in);

		int t = nI();
		if (t > 10 || t < 1) {
			return;
		}

		while (t-- > 0) {
			int n = nI();
			if (n > 100000 || n < 1) {
				return;
			}

			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = nI();
				if (a[i] > 1000 || a[i] < 0) {
					return;
				}
			}

			int count = 0;

			for (int i = 1; i < n; i++) {
				for (int j = i + 1; j <= n; j++) {
					int sum = a[i] + a[j];
					for (int k = 1; k <= n; k++) {
						if (2 * a[k] == sum) {
							count++;
							break;
						}
					}
				}
			}
			System.out.println(count);

		}
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
