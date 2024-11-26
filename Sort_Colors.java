/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
  Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]*/


// class Solution {
//     public void sortColors(int[] nums) {
//         int red =0;
//         int white=1;
//         int blue=2;
//         for(int i=0;i<nums.length;i++){// This loop will bring all the colur in adjacent but not in sorted order as (0,1,2)
//              for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]==nums[j]){
//                     int temp=nums[i+1];
//                      nums[i+1]=nums[j];
//                      nums[j]=temp;
//                 }
//              }
       
//         }
//        for (int i = 0; i < nums.length; i++) {//for sorting the colur in given order as (0,1,2)
//     int minIndex = i;
//     for (int j = i + 1; j < nums.length; j++) {
//         if (nums[j] < nums[minIndex]) {
//             minIndex = j;
//         }
//     }
//     int temp = nums[i];
//     nums[i] = nums[minIndex];
//     nums[minIndex] = temp;
// }
class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int i=0;
        while(i<=r){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[l];
                nums[l]=temp;
                l++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                int temp=nums[i];
                nums[i]=nums[r];
                nums[r]=temp;
                r--;
            }
        }
        
    }
}
