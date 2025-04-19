/*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.
Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
*/



// Approach 1:- Top Down DP Approach
// class Solution {
//     public int uniquePaths(int m, int n) {
//          int storage[][]=new int[m][n];
//          for(int i=0;i<m;i++){
//           for(int j=0;j<n;j++){
//              storage[i][j]=-1;
//           }
//          }
//          return Memopath(storage,m-1,n-1);
//     }
//     public int Memopath(int[][]storage,int row,int col){
//        if(row==0 && col==0){
//           return 1;
//        }
//        if(row<0 || col<0){
//           return 0;
//        }
//        if(storage[row][col]!=-1){
//           return storage[row][col];
//        }
//       int left=Memopath(storage,row,col-1);// we start from top so right convert to left
//       int up=Memopath(storage,row-1,col);// dowm change to up as top down approach
//       return storage[row][col]=left+up;

// Approach 2:-  Using Bottom up Approach (O(m*n) space and time O(m*n))
     class Solution {
     public int uniquePaths(int m, int n) {
      int dp[][]=new int[m][n];
     dp[0][0]=0;
     for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(i==0 && j==0){
          dp[i][j]=1;
        }else{
         int left=0;
         int up=0;
         if(i>0){
           up=dp[i-1][j];
         }
         if(j>0){
          left=dp[i][j-1];
         }
         dp[i][j]=left+up;
      }
     }
     }
          return dp[m-1][n-1];
    }
}
