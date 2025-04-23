/*Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

// Approach 1:- Using Top down (Memoization Approach)
class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        for(int num:nums){
           totalsum+=num;
        }
        if(totalsum%2!=0){
          return false;
        }
        int target = totalsum/2;
        Boolean[][]storage = new Boolean[nums.length][target+1];
        return partition(storage,nums,target,nums.length-1);
    }
    public Boolean partition(Boolean[][]storage,int[]nums,int target,int index){
      if(target==0){
        return true;
      }
          if(index==0){
             return nums[0]==target;
          }
          if(storage[index][target]!=null){
            return storage[index][target];
          }
          Boolean notpick = partition(storage,nums,target,index-1);
          Boolean pick=false;
          if(nums[index]<target){
            pick= partition(storage,nums,target-nums[index],index-1);
          }
          return storage[index][target]= notpick || pick;
    }
}

//     import java.util.*;
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int total = 0;
//         for (int num : nums) {
//             total += num;
//         }
//         if (total % 2 != 0) return false;

//         int target = total / 2;
//         boolean[] dp = new boolean[target + 1];
//         dp[0] = true;

//         for (int num : nums) {
//             for (int j = target; j >= num; j--) {
//                 dp[j] = dp[j] || dp[j - num];
//             }
//         }
//         return dp[target];
//     }
// }       
