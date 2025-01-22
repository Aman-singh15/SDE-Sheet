/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]] */

// Approach 1:-
// import java.util.*;
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         List<List<Integer>> ans=new ArrayList<>();
//           Set<List<Integer>> sets = new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//           for(int j=i+1;j<nums.length;j++){
//             for(int k=j+1;k<nums.length;k++){
//               for(int l=k+1;l<nums.length;l++){
//                  long sum= nums[i]+nums[j];
//                  sum+=nums[k];
//                  sum+=nums[l];
//                  if(sum==target){
//                   List<Integer>list=new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
//                     Collections.sort(list);
//                     if(sets.add(list)){
//                         ans.add(list);
//                     }
//                  }
//               }
//             }
//           }
//         }
//         return ans;
//     }
// }

// Approach 2:- we use 3 loop and compute their sum and then subtract it from target and check the value which is in between i,j and k(As k increas it first put previous value in set,while iterating next  for i or j then New set start to contain element and comparison start ) which is in set ,if it is present then we add this quad into out answer list.

import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
           Set<List<Integer>> sets = new HashSet<>();
        for(int i=0;i<nums.length;i++){
          for(int j=i+1;j<nums.length;j++){
              Set<Long> set = new HashSet<>();// 
            for(int k=j+1;k<nums.length;k++){
               long sum= nums[i]+nums[j];// we use long to avoid integer overflow 
                  sum+=nums[k];
                  long fourth=target-sum;
                  if(set.contains(fourth)){
                    List<Integer>list=new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k],(int)fourth));
                      Collections.sort(list);
                     if(sets.add(list)){
                        ans.add(list);
                    }
                  }
                  set.add((long)nums[k]);
            }
          }
        }
        return ans;
    }
}
