/*You are given two strings s1 and s2. Your task is to find the length of the longest common substring among the given strings.
Examples:
Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" with a length of 4.
Input: s1 = "abc", s2 = "acb"
Output: 1
Explanation: The longest common substrings are "a", "b", "c" all having length 1.
Input: s1 = "YZ", s2 = "yz"
Output: 0
Constraints:
1 <= s1.size(), s2.size() <= 103
Both strings may contain upper and lower case alphabets.
*/


// Approach 1:- using Top down-But we are using 3D Array so for long input can throw TLE
// class Solution {
//     public int longestCommonSubstr(String s1, String s2) {
//         int m = s1.length();
//         int n = s2.length();
//         Integer[][][] storage = new Integer[m + 1][n + 1][Math.min(m, n) + 1];
//         return lcsMemo(storage,s1,s2,m-1,n-1,0);
//     }
//     public int lcsMemo(Integer[][][]storage,String s1,String s2,int i,int j,int count){
//         if(i<0 || j<0 ){
//             return count;
//         }
//         if(storage[i][j][count]!=null){
//             return storage[i][j][count];
//         }
//         int c=count;
//         if(s1.charAt(i)==s2.charAt(j)){
//             c= lcsMemo(storage,s1,s2,i-1,j-1,count+1);
//         }
//             int option1 = lcsMemo(storage,s1,s2,i-1,j,0);
//             int option2 = lcsMemo(storage,s1,s2,i,j-1,0);
//             return storage[i][j][count]= Math.max(c,Math.max(option1,option2));
        
//     }
// }
// Approach 2:- Using Bottom up Approach 

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }
}

