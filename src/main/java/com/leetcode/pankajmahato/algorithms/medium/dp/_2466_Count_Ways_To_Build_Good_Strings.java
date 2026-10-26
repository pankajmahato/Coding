/**********************************************************************************
 *
 * https://leetcode.com/problems/count-ways-to-build-good-strings/
 *
 * Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:
 *
 * Append the character '0' zero times.
 * Append the character '1' one times.
 * This can be performed any number of times.
 *
 * A good string is a string constructed by the above process having a length between low and high (inclusive).
 *
 * Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 3, high = 3, zero = 1, one = 1
 * Output: 8
 * Explanation: 
 * One possible valid good string is "011". 
 * It can be constructed as follows: "" -> "0" -> "01" -> "011". 
 * All binary strings from "000" to "111" are good strings in this example.
 * Example 2:
 *
 * Input: low = 2, high = 3, zero = 1, one = 2
 * Output: 5
 * Explanation: The good strings are "00", "11", "000", "110", and "011".
 *
 *
 * Constraints:
 *
 * 1 <= low <= high <= 105
 * 1 <= zero, one <= low
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _2466_Count_Ways_To_Build_Good_Strings {

//    public int countGoodStrings(int low, int high, int zero, int one) {
//
//        //DP Top Down
//
//        // dp[i] = Count for string of length i
//        int[] dp = new int[high + 1];
//        Arrays.fill(dp, -1);
//
//        return solve(0, low, high, zero, one, dp);
//    }
//
//    private int solve(int len, int low, int high, int zero, int one, int[] dp) {
//
//        int MOD = 1_000_000_007;
//
//        if (len > high) {
//            return 0;
//        }
//
//        if (dp[len] != -1) {
//            return dp[len];
//        }
//
//        int addCurr = 0;
//        if (len >= low && len <= high) {
//            addCurr = 1;
//        }
//
//        int addZero = solve(len + zero, low, high, zero, one, dp);
//        int addOne = solve(len + one, low, high, zero, one, dp);
//
//        return dp[len] = (addCurr + addZero + addOne) % MOD;
//    }

    public int countGoodStrings(int low, int high, int zero, int one) {

        int MOD = 1_000_000_007;

        //DP Bottom Up

        // dp[i] = Count for string of length i
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {

            int addZero = i - zero < 0 ? 0 : dp[i - zero];
            int addOne = i - one < 0 ? 0 : dp[i - one];

            dp[i] = (addZero + addOne) % MOD;
        }

        int result = 0;

        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % MOD;
        }

        return result;
    }
}
