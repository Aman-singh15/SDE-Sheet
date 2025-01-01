//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
 
class Solution {
    public int findDuplicate(int[] nums) {
   //   Approach 1:- Gives time limit exceeded on higher test case
       //int ans=0;
      //   for(int i=0;i<nums.length;i++){
      //      for(int j=i+1;j<nums.length;j++){
      //         if(nums[i]==nums[j]){
      //           ans=nums[i];
      //             break;
      //         }
      //      }
      //   }
      //   return ans;
      // Approach 2:-Good
      // Arrays.sort(nums);
      // for(int i=0;i<nums.length-1;i++){
      //     if(nums[i]==nums[i+1]){
      //        ans=nums[i];
      //        break;
      //     }
      // }
      // return ans;
         
         //Approach 3:-Better

        boolean[] visited = new boolean[nums.length]; 
        for(int num: nums) {
            if(visited[num]) { // if same number is visited again
                return num; // duplicate number
            }
            visited[num] = true; 
        }

        return -1;

    }
}
