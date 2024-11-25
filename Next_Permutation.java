/*A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.*/
// Example 1:
// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:
// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:
// Input: nums = [1,1,5]
// Output: [1,5,1]

// class Solution {
//     public void nextPermutation(int[] nums) {
//         int smallLarge=-1;
//         for(int i=nums.length-2;i>=0;i--){
//             if(nums[i]<nums[i+1]){
//                 int min=Integer.MAX_VALUE;
//                 for(int j=i+1;j<nums.length;j++){
//                       if(nums[j]>nums[i]){
//                           if(min>nums[j]){
//                             min=nums[j];
//                             smallLarge=j;
//                           }
//                       }
//                 }
//                       int c=nums[i];
//                       nums[i]=nums[smallLarge];
//                       nums[smallLarge]=c;
//                 for(int t=nums.length-1;t>i+1;t--){
//                     int k=nums[t];
//                     nums[t]=nums[t-1];
//                     nums[t-1]=k;
//                 }
                      
//                 return;
//             }
            
//         }
//         int start=0;
//         int end=nums.length-1;
//         while(start<end){
//             int temp=nums[start];
//             nums[start]=nums[end];
//             nums[end]=temp;
//             start++;
//             end--;
//         }
//     }
// }
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int smallLarge = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                smallLarge = i;
                break;
            }
        }

        // If no such element is found, reverse the array (last permutation)
        if (smallLarge == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the smallest element larger than nums[smallLarge]
        for (int j = n - 1; j > smallLarge; j--) {
            if (nums[j] > nums[smallLarge]) {
                // Swap nums[smallLarge] with nums[j]
                int temp = nums[smallLarge];
                nums[smallLarge] = nums[j];
                nums[j] = temp;
                break;
            }
        }

        // Step 3: Reverse the subarray to the right of smallLarge
        reverse(nums, smallLarge + 1, n - 1);
    }

    // Helper function to reverse a subarray
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
