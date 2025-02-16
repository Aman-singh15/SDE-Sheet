/*Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that has a sum of 0.
Examples:
Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The subarray is [0, -4, 3, 1, 0]. */

// class Solution {
//     int maxLen(int arr[]) {
//       //  int length=0;
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<arr.length;i++){
//             int sum=0;
//             int length=0;
//             for(int j=i;j<arr.length;j++){
//                  sum+=arr[j];
//                  length++; 
//                 if(sum==0){
//                     if(length>max){
//                         max=length;
//                     }
//                 }
//             }
//         }
//         if(max>=1){
//             return max;
//         }
//         return 0;
//     }
// }

class Solution {
    int maxLen(int arr[]) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int maxLength=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
              maxLength=i+1;
            }
            if(map.containsKey(sum)){
                maxLength=Math.max(maxLength,i-map.get(sum));//(update the value of length which gives zero by comparing it with previous maxLength)
            }else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}
