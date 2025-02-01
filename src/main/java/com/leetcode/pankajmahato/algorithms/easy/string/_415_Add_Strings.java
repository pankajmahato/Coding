/**********************************************************************************
 *
 * https://leetcode.com/problems/add-strings/
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _415_Add_Strings {

    public String addStrings(String num1, String num2) {

        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;

        // Max length = Math.max(num1.length() + num2.length) + 2
        int maxLen = Math.max(n1, n2) + 2;
        char[] result = new char[maxLen];

        int sum = 0;
        while (n1 >= 0 || n2 >= 0) {

            if (n1 >= 0) {
                sum += num1.charAt(n1) - '0';
                n1--;
            }

            if (n2 >= 0) {
                sum += num2.charAt(n2) - '0';
                n2--;
            }

            // Get the digit
            result[--maxLen] = (char) ((sum % 10) + '0');

            // Store the carry
            sum = sum / 10;
        }

        // If there is carry
        if (sum != 0) {

            // Both are same for Sum
            // result[0] = '1';
            result[0] = (char) ((sum % 10) + '0');
            return new String(result);
        }

        // For no carry
        return new String(result, 1, result.length - 1);
    }

//    public String addDecimal(String num1, String num2) {
//
//        int num1Index = num1.indexOf('.');
//        int num2Index = num2.indexOf('.');
//        String intNum1 = num1.substring(0, num1Index);
//        String intNum2 = num2.substring(0, num2Index);
//
//        String fractionalNum1 = num1.substring(num1Index + 1);
//        String fractionalNum2 = num2.substring(num2Index + 1);
//
//        int fractionalNum1Len = fractionalNum1.length();
//        int fractionalNum2Len = fractionalNum2.length();
//        int diff = fractionalNum1Len - fractionalNum2Len;
//        if (diff > 0) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < diff; i++) {
//                sb.append('0');
//            }
//            fractionalNum2 = fractionalNum2 + sb.toString();
//        } else if (diff < 0) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < diff * -1; i++) {
//                sb.append('0');
//            }
//            fractionalNum1 = fractionalNum1 + sb.toString();
//        }
//
//        String fractionalSum = addStrings(fractionalNum1, fractionalNum2, 0);
//        int carry = 0;
//        if (fractionalSum.length() > fractionalNum1Len) {
//            carry = 1;
//            fractionalSum = fractionalSum.substring(1);
//        }
//        String intSum = addStrings(intNum1, intNum2, carry);
//        return intSum + "." + fractionalSum;
//    }
//
//    public String addStrings(String num1, String num2, int carry) {
//
//        int n1 = num1.length() - 1;
//        int n2 = num2.length() - 1;
//
//        // Max length = Math.max(num1.length() + num2.length) + 2
//        int maxLen = Math.max(n1, n2) + 2;
//        char[] result = new char[maxLen];
//
//        int sum = carry;
//        while (n1 >= 0 || n2 >= 0) {
//
//            if (n1 >= 0) {
//                sum += num1.charAt(n1) - '0';
//                n1--;
//            }
//
//            if (n2 >= 0) {
//                sum += num2.charAt(n2) - '0';
//                n2--;
//            }
//
//            // Get the digit
//            result[--maxLen] = (char) ((sum % 10) + '0');
//
//            // Store the carry
//            sum = sum / 10;
//        }
//
//        // If there is carry
//        if (sum != 0) {
//
//            // Both are same for Sum
//            // result[0] = '1';
//            result[0] = (char) ((sum % 10) + '0');
//            return new String(result);
//        }
//
//        // For no carry
//        return new String(result, 1, result.length - 1);
//    }
//
//    public static void main(String[] args) {
//        _415_Add_Strings obj = new _415_Add_Strings();
//        System.out.println(obj.addDecimal("99999999999999.99999999999","99999999999999.99999999999"));
//    }
}
