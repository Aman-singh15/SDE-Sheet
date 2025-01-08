/*Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?
Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104 */


import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int i=0;
        for(;i<k;i++){
           pq.add(nums[i]);
        }
        for(int j=i;j<nums.length;j++){
            int min=pq.element();
            if(nums[j]>min){
                pq.remove();
                pq.add(nums[j]);
            }
        }
        return pq.remove();
    //     for(int i=0;i<nums.length;i++){
    //         pq.add(nums[i]);
    //     }
    //     for(int j=0;j<nums.length;j++){
    //         nums[j]=pq.remove();
    //     }
    //    // if(k<=nums.length){
    //         return nums[k-1];
    //    // }
    //     //return -1;
}
}
