/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.
Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10  */

// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         HashMap<Integer,Integer>map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         for(Map.Entry<Integer,Integer>entry: map.entrySet()){
//             if(entry.getValue()==1){
//                  return entry.getKey();
//             }
//         }
//         return 0;
//     }
// }

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        for (int i = 0; i < n; i++) {
            if (i == 0) {// for first index
                if (nums[i] != nums[i + 1])
                    return nums[i];
            }
            else if (i == n - 1) {// for last index
                if (nums[i] != nums[i - 1])
                    return nums[i];
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])// if both side different
                    return nums[i];
            }
        }
          return -1;
    }
}
