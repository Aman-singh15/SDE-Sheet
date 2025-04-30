/*Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters.
*/



class Solution {
    public int longestPalindromeSubseq(String s) {
        int n= s.length();
        Integer[][]storage = new Integer[n][n];
       return longestMemo(s,storage,0,n-1);
    }
    public int longestMemo(String s,Integer[][]storage,int start,int end){
         if(start>end){
            return 0;
         }
         if(start==end){
           return 1;
         }
         if(storage[start][end]!=null){
           return storage[start][end];
         }
         if(s.charAt(start)==s.charAt(end)){
            return 2+  longestMemo(s,storage,start+1,end-1);
         }else{
            int option1= longestMemo(s,storage,start+1,end);
            int option2 =  longestMemo(s,storage,start,end-1);
            return storage[start][end]=Math.max(option1,option2);
         }
    }
}
