/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
*/


// Approach 1:- Using Memoization(O(m * n)) time and space complexity
// class Solution {
//     public int minPathSum(int[][] grid) {
//       int m=grid.length;
//       int n=grid[0].length;
//         int[][]storage = new int[m][n];
//         for(int[] row:storage){
//           Arrays.fill(row,-1);
//         }
//         return pathSumMemo(grid,storage,m-1,n-1);
//     }
//     public int pathSumMemo(int[][]grid,int[][]storage,int row,int col){
//         if(row==0 && col==0){
//             return grid[0][0];
//         }
//         if(row<0 || col<0){
//             return Integer.MAX_VALUE;
//         }
//         if(storage[row][col]!=-1){
//            return storage[row][col];
//         }
//         int left=pathSumMemo(grid,storage,row,col-1);
//         int up=pathSumMemo(grid,storage,row-1,col);
//         return storage[row][col]= grid[row][col]+Math.min(left,up);
//     }
// }

// Approach 2:- Using DP(Bottom up)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];  // starting cell
                } else {
                    int up = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
