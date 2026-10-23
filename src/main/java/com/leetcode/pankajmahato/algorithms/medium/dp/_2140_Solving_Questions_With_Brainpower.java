/**********************************************************************************
 *
 * https://leetcode.com/problems/solving-questions-with-brainpower/
 *
 * You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
 *
 * The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
 *
 * For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 * If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
 * If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
 * Return the maximum points you can earn for the exam.
 *
 *
 *
 * Example 1:
 *
 * Input: questions = [[3,2],[4,3],[4,4],[2,5]]
 * Output: 5
 * Explanation: The maximum points can be earned by solving questions 0 and 3.
 * - Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
 * - Unable to solve questions 1 and 2
 * - Solve question 3: Earn 2 points
 * Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
 * Example 2:
 *
 * Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * Output: 7
 * Explanation: The maximum points can be earned by solving questions 1 and 4.
 * - Skip question 0
 * - Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
 * - Unable to solve questions 2 and 3
 * - Solve question 4: Earn 5 points
 * Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
 *
 *
 * Constraints:
 *
 * 1 <= questions.length <= 105
 * questions[i].length == 2
 * 1 <= pointsi, brainpoweri <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _2140_Solving_Questions_With_Brainpower {

    // public long mostPoints(int[][] questions) {

    //     // DP Top Down
    //     int n = questions.length;

    //     // dp[i] = Result from index i
    //     long[] dp = new long[n];
    //     Arrays.fill(dp, -1L);

    //     return solve(0, n, questions, dp);
    // }

    // private long solve(int i, int n, int[][] questions, long[] dp) {

    //     if (i >= n) {
    //         return 0;
    //     }

    //     if (dp[i] != -1) {
    //         return dp[i];
    //     }

    //     long skip = solve(i + 1, n, questions, dp);
    //     long take = questions[i][0] + solve(i + 1 + questions[i][1], n, questions, dp);

    //     return dp[i] = Math.max(skip, take);
    // }

    public long mostPoints(int[][] questions) {

        // DP Bottom Up
        int n = questions.length;

        // dp[i] = Result from index i
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            long skip = dp[i + 1];
            int nextIndex = Math.min(n, i + 1 + questions[i][1]);
            long take = questions[i][0] + dp[nextIndex];

            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }
}
