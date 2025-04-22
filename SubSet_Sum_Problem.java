/*Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 
Examples:
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
*/


class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean storage[][]=new Boolean[arr.length][sum+1];
        return isSum(storage,arr,arr.length-1,sum);
    }
    static Boolean isSum(Boolean[][]storage,int[]arr,int index,int target){
             if(target==0){
                 return true;
             }
             if(index==0){
                 return arr[0]==target;
             }
             if(storage[index][target]!=null){
                 return storage[index][target];
             }
             
             boolean nottake = isSum(storage,arr,index-1,target);
              boolean take = false;
         if (arr[index] <= target) {
           take = isSum(storage, arr, index - 1, target - arr[index]); 
        }
        
        return storage[index][target]= nottake || take;
    }
}
