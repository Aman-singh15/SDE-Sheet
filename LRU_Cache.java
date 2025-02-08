/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4     */

// Approach 1:- Using Stack and HashMap which takes O(n) time complexity
// import java.util.*;
// class LRUCache {
//     HashMap<Integer, Integer> map = new HashMap<>();
//     private final int capacity;
//     Stack<Integer> stack;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         this.map = new HashMap<>(capacity);
//         stack = new Stack<>();
//     }

//     public int get(int key) {
//         if (!map.containsKey(key)) {
//             return -1;
//         }
//         // making the key as Most Recently Used by removing and then adding it in the stack 
//         stack.remove((Integer) key); // Remove it from stack
//         stack.push(key); // Push it to mark as most recently used
//         return map.get(key);
//     }

//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             // If key exists, update its value and move it to the top to make it MRU
//             map.put(key, value);
//             stack.remove((Integer) key);
//             stack.push(key);
//             return;
//         }

//         if (map.size() >= capacity) {
//             // Remove the Least Recently Used (bottom of the stack)
//             int lruKey = stack.remove(0); // Remove first inserted element
//             map.remove(lruKey);
//         }
//         // Inserting the new key-value
//         map.put(key, value);
//         stack.push(key);
//     }
// }

// Approach 2:- Using LinkedHashMap which takes O(1) time complexity for get and put

import java.util.*;
class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // true = maintain access order (LRU behavior)
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        //true → is Access Order (Moves recently accessed elements to the end, making LRU removal easy). if false then it insert as element came
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value); //updating the key
            return;
        }
        
        if (map.size() >= capacity) {
            // Remove the least recently used entry
            int lruKey = map.keySet().iterator().next();
            //cache.keySet() – Gets the set of keys in LinkedHashMap.
// .iterator() – Creates an iterator to loop through the keys.
 // .next() – Gets the first key in the iteration.(as the first key is LRU key) and we remove this key
            map.remove(lruKey);
        }
        
        map.put(key, value); // insert new key-value pair
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
