/**********************************************************************************
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 *
 * Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
 *
 * The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
 *
 *
 *
 * Example 1:
 *
 * Input: expression = "2-1-1"
 * Output: [0,2]
 * Explanation:
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: expression = "2*3-4*5"
 * Output: [-34,-14,-10,-10,10]
 * Explanation:
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 *
 *
 * Constraints:
 *
 * 1 <= expression.length <= 20
 * expression consists of digits and the operator '+', '-', and '*'.
 * All the integer values in the input expression are in the range [0, 99].
 * The integer values in the input expression do not have a leading '-' or '+' denoting the sign.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.recursion;

import java.util.ArrayList;
import java.util.List;

public class _241_Different_Ways_to_Add_Parentheses {

    public List<Integer> solve(String expression, int start, int end) {

        List<Integer> result = new ArrayList<>();

        for (int i = start; i < end; i++) {

            switch (expression.charAt(i)) {
                case '+':
                case '-':
                case '*': {
                    List<Integer> left = diffWaysToCompute(expression.substring(start, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1, end));

                    for (Integer l : left) {
                        for (Integer r : right) {
                            switch (expression.charAt(i)) {
                                case '+': {
                                    result.add(l + r);
                                    break;
                                }
                                case '-': {
                                    result.add(l - r);
                                    break;
                                }
                                case '*': {
                                    result.add(l * r);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression, 0, expression.length());
    }

    public static void main(String[] args) {
        System.out.println(new _241_Different_Ways_to_Add_Parentheses().diffWaysToCompute("2*3-4*5"));
    }
}
