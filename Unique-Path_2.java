/*You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.
Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
*/




class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
           return 0;
        }
        int[][]storage = new int[obstacleGrid.length][obstacleGrid[0].length];
         for(int i=0;i<obstacleGrid.length;i++){
          for(int j=0;j<obstacleGrid[0].length;j++){
             storage[i][j]=-1;
          }
         }
        return uniqueMemo(storage,obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1);
    }
    public int uniqueMemo(int[][]storage,int[][]obstacleGrid,int m,int n){
        if(m==0 && n==0){
            return 1;
            // return storage[m][n]=1;
        }
        if(m<0 || n<0){
          return 0;
        }
        if(obstacleGrid[m][n]==1){
            return 0;
        }
        if(storage[m][n]!=-1){
          return storage[m][n];
        }
        int left = uniqueMemo(storage,obstacleGrid,m,n-1);//left
        int right = uniqueMemo(storage,obstacleGrid,m-1,n);//up
        return storage[m][n]=left+right;
    }
}
