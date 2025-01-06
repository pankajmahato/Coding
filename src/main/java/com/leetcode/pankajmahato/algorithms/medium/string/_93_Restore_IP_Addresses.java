/**********************************************************************************
 *
 * https://leetcode.com/problems/restore-ip-addresses/
 *
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

import java.util.ArrayList;
import java.util.List;

public class _93_Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        int n = s.length();

        if (n <= 12) {
            int idx = 0;
            int parts = 0;
            String curr = "";
            backtrack(s, n, idx, parts, curr, result);
        }

        return result;
    }

    private void backtrack(String s, int n, int idx, int parts, String curr, List<String> result) {

        if (idx == n && parts == 4) {
            result.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if (idx + 1 <= n) {
            backtrack(s, n, idx + 1, parts + 1, curr + s.substring(idx, idx + 1) + ".", result);
        }

        if (idx + 2 <= n && isValid(s.substring(idx, idx + 2))) {
            backtrack(s, n, idx + 2, parts + 1, curr + s.substring(idx, idx + 2) + ".", result);
        }

        if (idx + 3 <= n && isValid(s.substring(idx, idx + 3))) {
            backtrack(s, n, idx + 3, parts + 1, curr + s.substring(idx, idx + 3) + ".", result);
        }
    }

    private boolean isValid(String str) {

        if ((str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) {
            return false;
        }

        return true;
    }
}
