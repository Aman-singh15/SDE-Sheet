/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Example 1:
Input: nums = [3,2,3]
Output: [3]
Example 2:
Input: nums = [1]
Output: [1]
Example 3:
Input: nums = [1,2]
Output: [1,2] */


import java.util.HashMap;
import java.util.ArrayList;
//import java.util.*;
// Approach 1:- O(n)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans= new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        int limit=nums.length/3;
        for(int i=0;i<nums.length;i++ ){
            //map.put(map.getOrDefault(nums[i],0)+1); 
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                   map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getValue()> limit){
               ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
//     Approach 2:- O(n^2)
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//      ArrayList<Integer>ans = new ArrayList<>();
//       int limit = nums.length/3;
//       for(int i=0;i<nums.length;i++){
//           int count=0;
//         for(int j=0;j<nums.length;j++){
//              if(nums[i]==nums[j]){
//                 count++;
//              }
//         }
//           if(count>limit && !(ans.contains(nums[i]))){
//              ans.add(nums[i]);
//           }
//       }
//         return ans; 
//     }

// }
