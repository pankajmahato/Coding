/**********************************************************************************
 *
 * https://leetcode.com/problems/lru-cache/
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to get and put.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.linkedlist;

import java.util.LinkedHashMap;

public class _146_LRU_Cache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public _146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);

    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        int val = map.get(key);
        map.remove(key);
        map.put(key, val);

        return val;

    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            int firstKey = map.entrySet().iterator().next().getKey();
            map.remove(firstKey);
        }

        map.put(key, value);
    }
}
