/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]  */

// Approach 1:- Brute force Using O(N^2)
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         List<Integer>list=new ArrayList<>();
//         HashMap<Integer,Integer>map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         while(k>0){
//           int max=Integer.MIN_VALUE;
//           int key=Integer.MIN_VALUE;
//           for(Map.Entry<Integer,Integer>entry:map.entrySet()){
//             if(entry.getValue()>max){
//               max=entry.getValue();
//               key=entry.getKey();
//              // map.put(entry.getKey(),Integer.MIN_VALUE);    -> this throws a(ConcurrentModificationException) because we are Modifying the HahsMap during iteration.so we remove that key out of for loop...  
//             }
//           }
//           list.add(key);
//           map.remove(key);
//           k--;// to store this top K frequent Elements
//         }
//         int ans[]=new int[list.size()];
//         for(int i=0;i<ans.length;i++){
//             ans[i]=list.get(i);
//         }
//         return ans;
//     }
// }

// Approach 2:- Using PriorityQueue(Heap)
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Min-Heap based on frequency
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) { // Extract in reverse order to get correct order
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}

