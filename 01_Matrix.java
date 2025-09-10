/*Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two cells sharing a common edge is 1.
Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/


// class Solution {
//     int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
//     int m, n;
//     Integer[][] dp; 
//     public int[][] updateMatrix(int[][] mat) {
//         m = mat.length;
//         n = mat[0].length;
//         dp = new Integer[m][n];
//         int[][] ans = new int[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 ans[i][j] = dfs(mat, i, j);
//             }
//         }
//         return ans;
//     }
//     private int dfs(int[][] mat, int i, int j) {
//         if (i < 0 || j < 0 || i >= m || j >= n) return 1000000; // INF
//         if (mat[i][j] == 0) return 0;
//         if (dp[i][j] != null) return dp[i][j];
//         dp[i][j] = 1000000;
//         int best = Integer.MAX_VALUE;
//         for (int[] d : dirs) {
//             int ni = i + d[0], nj = j + d[1];
//             best = Math.min(best, 1 + dfs(mat, ni, nj));
//         }
//         return dp[i][j] = best;
//     }
// }


// using DP
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length, n = mat[0].length;
//         int[][] dist = new int[m][n];
//         int INF = m + n;

//         // First pass: top-left to bottom-right
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(mat[i][j] != 0) {
//                     int top = (i > 0) ? dist[i-1][j] : INF;
//                     int left = (j > 0) ? dist[i][j-1] : INF;
//                     dist[i][j] = Math.min(top, left) + 1;
//                 }
//             }
//         }

//         // Second pass: bottom-right to top-left
//         for(int i=m-1; i>=0; i--) {
//             for(int j=n-1; j>=0; j--) {
//                 if(mat[i][j] != 0) {
//                     int bottom = (i < m-1) ? dist[i+1][j] : INF;
//                     int right = (j < n-1) ? dist[i][j+1] : INF;
//                     dist[i][j] = Math.min(dist[i][j], Math.min(bottom, right) + 1);
//                 }
//             }
//         }

//         return dist;
//     }
// }

// Using BFS (GRAPH)

class Solution {
     public int[][] updateMatrix(int[][] mat) {
        int[][]dist = new int [mat.length][mat[0].length];
        Queue<int[]>queue = new LinkedList<>();
        int[][]visited = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
          for(int j=0;j<mat[0].length;j++){
             if(mat[i][j]==0){
              dist[i][j]=0;
              visited[i][j]=1;
                queue.add(new int[]{i,j});
             }else{
              visited[i][j]=-1;
             }
          }
        }
        int[][] dir = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
          while(!queue.isEmpty()){
            int[]cell=queue.poll();
            int x=cell[0];
            int y=cell[1];
            for(int[] dirtn:dir){
              int nx=x+dirtn[0];
              int ny=y+dirtn[1];
              if(nx>=0 &&  ny>=0 && nx<mat.length && ny<mat[0].length && visited[nx][ny]==-1){
                  dist[nx][ny]=dist[x][y]+1;
                  visited[nx][ny]=1;
                  queue.add(new int[]{nx,ny});
              }
            }
          }
          return dist;
     }
}
