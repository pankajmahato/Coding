package com.codechef.pankaj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class ChefMatrix {
	private static InputStream stream;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
	private static long MAX = 2000000000;





	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("d:\\programming\\case.txt"));
		InputReader(System.in);
		int testCases = nI();
		while (testCases-- > 0) {
			int n = nI();
			int m = nI();
			long[][] a = new long[n][m];
			boolean isPossible = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = nL();
				}
			}
			if (processRow(a, n - 1, m - 1) && processColumn(a, n - 1, m - 1)) {
				Outer: for (int i = n - 1; i >= 0; i--) {
					for (int j = m - 1; j >= 0; j--) {
						if (a[i][j] == -1) {
							a[i][j] = Math.min(a[i + 1][j], a[i][j + 1]);
						}
						if (i != n - 1 && j != m - 1) {
							if (a[i][j] > a[i][j + 1] || a[i][j] > a[i + 1][j]) {
								isPossible = false;
								break Outer;
							}
						}
					}
				}
			} else {
				isPossible = false;
			}
			if (isPossible) {
				printMatrix(a);
			} else {
				log.write("-1\n");
			}
		}
		log.flush();
	}





	public static boolean processRow(long[][] a, int i, int j) {
		boolean isPossible = true;
		long max = a[i][j];
		if (max == -1) {
			max = MAX;
			a[i][j] = MAX;
		}
		for (int c = j - 1; c >= 0; c--) {
			if (a[i][c] == -1) {
				a[i][c] = max;
			} else {
				max = a[i][c];
				if (a[i][c] > a[i][c + 1]) {
					isPossible = false;
					break;
				}
			}
		}
		return isPossible;
	}





	public static boolean processColumn(long[][] a, int i, int j) {
		boolean isPossible = true;
		long max = a[i][j];
		if (max == -1) {
			max = MAX;
			a[i][j] = MAX;
		}
		for (int c = i - 1; c >= 0; c--) {
			if (a[c][j] == -1) {
				a[c][j] = max;
			} else {
				max = a[c][j];
				if (a[c][j] > a[c + 1][j]) {
					isPossible = false;
					break;
				}
			}
		}
		return isPossible;
	}





	public static void printMatrix(long[][] a) throws IOException {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				log.write(String.valueOf(a[i][j] + " "));
			}
			log.write("\n");
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
