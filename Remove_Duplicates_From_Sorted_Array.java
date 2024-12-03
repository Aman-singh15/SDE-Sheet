//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
//The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// Example 2:
// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]


class Solution {
    public int removeDuplicates(int[] nums) {
    //    if(nums.length==0){
    //     return nums.length;
    //    }
        ArrayList<Integer>ans=new ArrayList<>();
       int i=0;
       int count=0;
       while(i<nums.length-1){
          if(nums[i]==nums[i+1]){
            i++;
         }else{
            count++;
            ans.add(nums[i]);
            i++;
         }
        }
     //  this step is for either say if given array length is 1 and also for inserting 
     // the last element of aaray in array list as unique character(as while check until length-1) 
            ans.add(nums[nums.length-1]);
            count++;
        for(int j=0;j<count;j++){
            nums[j]=ans.get(j);
        }
        for(int j=count;j<nums.length;j++){
            nums[j]=-1;
        }
        return count;
    }
}
