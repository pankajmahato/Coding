package com.codechef.pankajmahato.april18b;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.InputMismatchException;

public class GoodPrefix {

	//Count Good Prefixes
	//https://www.codechef.com/APRIL18B/problems/GOODPREF

	private static InputStream stream;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));





	public static void main(String[] args) throws IOException {
		InputReader(System.in);
		int testCases = nI();
		if (testCases > 100 || testCases < 1) {
			return;
		}
		while (testCases-- > 0) {
			String s = nS();
			long n = nL();
			if (s.length() > 1000 || n > 1000000000L || n < 1) {
				return;
			}
			//			StringBuilder str = new StringBuilder();
			//			for (long i = 0; i < n; i++) {
			//				str.append(s);
			//			}
			//			try {
			//				final Field field = String.class.getDeclaredField("value");
			//				field.setAccessible(true);
			//
			//				long total = 0;
			//				long aCount = 0;
			//				long bCount = 0;
			//				final char[] chars = (char[]) field.get(str.toString());
			//				final int len = chars.length;
			//				for (int i = 0; i < len; i++) {
			//					if (chars[i] == 'a') {
			//						aCount++;
			//					} else if (chars[i] == 'b') {
			//						bCount++;
			//					} else {
			//						throw new Exception();
			//					}
			//					if (aCount > bCount) {
			//						total++;
			//					}
			//				}
			//				System.out.println(total);
			//			} catch (Exception ex) {
			//				throw new IOException();
			//			}

			//			int k=0;
			//			long l = n*s.length();
			//			int ls=s.length();
			//			for(long i=0;i<l;i++){
			//
			//				if(s.charAt(k%ls)=='a'){
			//
			//				}
			//			}

			try {
				final Field field = String.class.getDeclaredField("value");
				field.setAccessible(true);
				long total = 0;
				long aCount = 0;
				long bCount = 0;
				final char[] chars = (char[]) field.get(s);
				final int len = chars.length;
				for (long i = 0; i < n; i++) {
					for (int j = 0; j < len; j++) {
						if (chars[j] == 'a') {
							aCount++;
						} else if (chars[j] == 'b') {
							bCount++;
						} else {
							throw new Exception();
						}
						if (aCount > bCount) {
							total++;
						}
					}
				}
				System.out.println(total);
			} catch (Exception ex) {
			}
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
