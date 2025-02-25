/*Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.
Examples :
Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.   */

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n=a.length;
        int m=b.length;
        int ans[]=new int[n+m];
        merge(ans,a,b);
        return ans[k-1];
    }
    public void merge(int[]ans,int[]a,int[]b){
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                ans[k]=a[i];
                i++;
                k++;
            }else{
                ans[k]=b[j];
                j++;
                k++;
            }
        }
        while(i<a.length){
           ans[k]=a[i];
           i++;
           k++;
        }
        while(j<b.length){
            ans[k]=b[j];
            j++;
            k++;
        }
    }
}
