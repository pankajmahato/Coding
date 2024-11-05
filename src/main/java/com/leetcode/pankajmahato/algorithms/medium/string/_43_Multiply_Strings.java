/**********************************************************************************
 *
 * https://leetcode.com/problems/multiply-strings/
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

public class _43_Multiply_Strings {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int res[] = new int[l1 + l2];
        int n1[] = new int[l1];
        int n2[] = new int[l2];
        for (int i = 0; i < l1; i++) {
            n1[i] = num1.charAt(l1 - i - 1) - '0';
        }
        for (int i = 0; i < l2; i++) {
            n2[i] = num2.charAt(l2 - i - 1) - '0';
        }
        int i = 0;
        int j = 0;
        int last = 0;
        for (i = 0; i < l1; i++) {
            int carry = 0;
            int pos = i;
            for (j = 0; j < l2; j++) {
                int sum = n1[i] * n2[j] + carry + res[pos];
                res[pos] = sum % 10;
                carry = sum / 10;
                pos++;
            }
            while (carry > 0) {
                int sum = (res[pos] + carry);
                res[pos] = sum % 10;
                carry = sum / 10;
                pos++;
            }
        }

        last = res.length - 1;
        while (last >= 0) {
            if (res[last] != 0)
                break;
            last--;
        }
        if (last == -1)
            return "0";

        StringBuilder sb = new StringBuilder();
        for (i = last; i >= 0; i--) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
