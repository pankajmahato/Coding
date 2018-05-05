package com.codechef.pankajmahato.locapr18;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author Pankaj Mahato(pankajmahato)
 * Perfect Necklace
 * https://www.codechef.com/LOCAPR18/problems/PERFNEC
 *
 */


public class PerfectNecklace {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		Task task = new Task();
		task.solve(in, out);
		closeStreams(out, in);
	}


	static class Task {


		public void solve(InputReader in, OutputWriter out) {
			List<List<Integer>> combinations = new ArrayList<>();
			int[] beauty = { -2, -1, 0, 1, 2 };

			int[] cost = IOUtils.readIntArray(in, 5);
			int q = in.readInt();
			for (int i = 1; i <= q; i++) {
				int x = in.readInt();
				int y = in.readInt();
				getCombination(beauty, beauty.length, x, true, combinations);
				int sum = 9999999;
				for (List<Integer> row : combinations) {
					// For Java 7
					//int sum = IntStream.of(a).sum();
					int beautySum = row.stream().mapToInt(Integer::intValue).sum();
					if (beautySum == y) {
						int tempCost = 0;
						for (int j = 0; j < row.size(); j++) {
							switch (row.get(j)) {
							case -2:
								tempCost = tempCost + cost[0];
								break;
							case -1:
								tempCost = tempCost + cost[1];
								break;
							case 0:
								tempCost = tempCost + cost[2];
								break;
							case 1:
								tempCost = tempCost + cost[3];
								break;
							case 2:
								tempCost = tempCost + cost[4];
								break;

							}
						}
						if (tempCost < sum) {
							sum = tempCost;
						}
					}
				}
				out.printLine(sum);
				//				System.out.println(sum);
				out.flush();
			}
		}





		/* arr[]  ---> Input Array
		data[] ---> Temporary array to store current combination
		start & end ---> Staring and Ending indexes in arr[]
		index  ---> Current index in data[]
		r ---> Size of a combination to be printed */
		static void combinationUtil(int arr[], int data[], int start, int end, int index, int r,
				List<List<Integer>> combinations) {
			// Current combination is ready to be printed, print it
			if (index == r) {
				List<Integer> list = new ArrayList<>();
				for (int j = 0; j < r; j++) {
					list.add(data[j]);
				}
				combinations.add(list);
				return;
			}

			// replace index with all possible elements. The condition
			// "end-i+1 >= r-index" makes sure that including one element
			// at index will make a combination with remaining elements
			// at remaining positions
			for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
				data[index] = arr[i];
				combinationUtil(arr, data, i + 1, end, index + 1, r, combinations);

				//				// Since the elements are sorted, all occurrences of an element
				//				// must be together
				//				while (arr[i] == arr[i + 1]) {
				//					i++;
				//				}
			}
		}





		// The main function that prints all combinations of size r
		// in arr[] of size n. This function mainly uses combinationUtil()
		static void getCombination(int arr[], int n, int r, boolean repeated, List<List<Integer>> combinations) {
			// A temporary array to store all combination one by one
			int data[] = new int[r];

			// Print all combination using temprary array 'data[]'
			combinationUtil(arr, data, 0, n - 1, 0, r, combinations);

			if (repeated) {
				for (int i = 0; i < arr.length; i++) {
					List<Integer> list = new ArrayList<>();
					for (int j = 0; j < r; j++) {
						list.add(arr[i]);
					}
					combinations.add(list);
				}
			}
		}
	}





	private static void closeStreams(OutputWriter out, InputReader in) throws IOException {
		out.flush();
		out.close();
		in.close();
	}

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;





		public InputReader(InputStream stream) {
			this.stream = stream;
		}





		public int read() {
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





		public int readInt() {
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





		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}





		public long readLong() {
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





		public String readString() {
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





		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}





		public boolean isEndOfLine(int c) {
			if (filter != null) {
				return filter.isEndOfLine(c);
			}
			return c == '\n' || c == '\r' || c == -1;
		}





		public String next() {
			return readString();
		}





		public void close() throws IOException {
			this.stream.close();
		}

		public interface SpaceCharFilter {
			boolean isSpaceChar(int ch);





			boolean isEndOfLine(int ch);
		}

	}

	static class IOUtils {

		public static int[] readIntArray(InputReader in, int elementCount) {
			return readIntArray(in, elementCount, 0);
		}





		public static int[] readIntArray(InputReader in, int elementCount, int startOffset) {
			int[] array = new int[elementCount + startOffset];
			for (int i = 0; i < elementCount; i++) {
				array[i + startOffset] = in.readInt();
			}
			return array;
		}





		public static long[] readLongArray(InputReader in, int elementCount) {
			return readLongArray(in, elementCount, 0);
		}





		public static long[] readLongArray(InputReader in, int elementCount, int startOffset) {
			long[] array = new long[elementCount + startOffset];
			for (int i = 0; i < elementCount; i++) {
				array[i + startOffset] = in.readLong();
			}
			return array;
		}

	}

	static class OutputWriter {

		private final PrintWriter writer;





		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}





		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}





		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
		}





		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}





		public void close() {
			writer.close();
		}





		public void flush() {
			writer.flush();
		}

	}
}
