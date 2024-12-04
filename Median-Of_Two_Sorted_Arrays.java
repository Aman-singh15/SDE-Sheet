//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

  
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0;
        int j=0;
        int k=0;
        double median=0.00;
        int ans[]=new int[n+m];
     while(i<m && j<n){
                         if(nums1[i]<nums2[j]){
                            ans[k]=nums1[i];
                            i++;
                            k++;
                         }else{
                            ans[k]=nums2[j];
                            j++;
                            k++;
                         }

                     }
                while(i<m){
                             ans[k]=nums1[i];
                               i++;
                                k++;
                         }
                while(j<n){
                              ans[k]=nums2[j];
                              k++;
                              j++;

                            }
                   if(k%2!=0){
                   return (double)ans[k/2];
                   }
            return (double)(ans[(k-1)/2]+ans[k/2])/2.0;
                
    }
   
    
}
