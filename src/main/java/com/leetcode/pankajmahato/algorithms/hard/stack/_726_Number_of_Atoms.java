/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-atoms/
 *
 * Given a string formula representing a chemical formula, return the count of each atom.
 *
 * The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 *
 * One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.
 *
 * For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
 * Two formulas are concatenated together to produce another formula.
 *
 * For example, "H2O2He3Mg4" is also a formula.
 * A formula placed in parentheses, and a count (optionally added) is also a formula.
 *
 * For example, "(H2O2)" and "(H2O2)3" are formulas.
 * Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 *
 * The test cases are generated so that all the values in the output fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: formula = "H2O"
 * Output: "H2O"
 * Explanation: The count of elements are {'H': 2, 'O': 1}.
 * Example 2:
 *
 * Input: formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3:
 *
 * Input: formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 *
 *
 * Constraints:
 *
 * 1 <= formula.length <= 1000
 * formula consists of English letters, digits, '(', and ')'.
 * formula is always valid.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _726_Number_of_Atoms {

    public String countOfAtoms(String formula) {

        int n = formula.length();
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();

        stack.push(new HashMap<>());

        int i = 0;
        while (i < n) {
            // Push a empty map for the new group
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                // Get the current group
                Map<String, Integer> currMap = stack.pop();
                i++;

                // Get multiplier count
                StringBuilder countStr = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    countStr.append(formula.charAt(i));
                    i++;
                }

                // If multiplier is available multiply for the all the elements of the current
                // group
                if (!countStr.isEmpty()) {
                    int count = Integer.parseInt(countStr.toString());
                    for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue() * count;
                        currMap.put(key, value);
                    }
                }

                // Merge the current group with the group on top
                for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();

                    Map<String, Integer> topMap = stack.peek();
                    topMap.put(key, topMap.getOrDefault(key, 0) + value);
                }
            } else {
                // Now only Element is present
                StringBuilder currElement = new StringBuilder();
                currElement.append(formula.charAt(i));
                i++;
                // Get the lowercase part
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    currElement.append(formula.charAt(i));
                    i++;
                }

                // Get Element count
                StringBuilder countStr = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    countStr.append(formula.charAt(i));
                    i++;
                }

                // Add the element to the top of the stack
                int count = countStr.isEmpty() ? 1 : Integer.parseInt(countStr.toString());
                Map<String, Integer> topMap = stack.peek();
                if (topMap.containsKey(currElement.toString())) {
                    topMap.put(currElement.toString(), topMap.get(currElement.toString()) + count);
                } else {
                    topMap.put(currElement.toString(), count);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        // Sort based on Element name
        Map<String, Integer> sortedMap = new TreeMap<String, Integer>();
        sortedMap.putAll(stack.peek());

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            result.append(key);
            if (value != 1) {
                result.append(value);
            }
        }

        return result.toString();
    }
}
