/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/


class Solution {
    public int numIslands(char[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        boolean visited[][]= new boolean[m][n];
        int count=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
          if(grid[i][j]=='1' && !visited[i][j]){
              count++;
              dfs(grid,i,j,visited);
          }
        }
       }
        return count;
    }
    public void dfs(char[][]grid, int row, int col, boolean[][]visited){
       int m =grid.length;
        int n = grid[0].length;
      if(row<0 || col<0 || row>=m || col>=n || grid[row][col]=='0' || visited[row][col]){
          return ;
      }
          visited[row][col]=true;
          // we check on all 4 direction
          dfs(grid, row,col+1,visited);// right
          dfs(grid,row,col-1,visited); // left
          dfs(grid,row-1,col,visited); // up
          dfs(grid,row+1,col,visited); // down
    }
}
