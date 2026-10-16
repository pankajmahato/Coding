/**********************************************************************************
 *
 * https://leetcode.com/problems/my-calendar-i/
 *
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
 *
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
 *
 * The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.
 *
 * Implement the MyCalendar class:
 *
 * MyCalendar() Initializes the calendar object.
 * boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * Output
 * [null, true, false, true]
 *
 * Explanation
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
 * myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
 *
 *
 * Constraints:
 *
 * 0 <= start < end <= 109
 * At most 1000 calls will be made to book.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Map;
import java.util.TreeMap;

public class _729_My_Calendar_I {

    // End Time -> Start Time
    TreeMap<Integer, Integer> calendar = new TreeMap<>();

//    public MyCalendar() {
//        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
//    }

    public boolean book(int startTime, int endTime) {

        // Fetch the existing next pair having its end time greater than given start time
        Map.Entry<Integer, Integer> pair = calendar.higherEntry(startTime);

        // Given end time is less than the existing next pair's start time
        boolean result = endTime <= pair.getValue();

        if (result) {
            calendar.put(endTime, startTime);
        }

        return result;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
