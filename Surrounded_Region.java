/*You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation:
In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/

// With O(m*n) time and space complexity
// class Solution {
//     public void solve(char[][] board) {
//         int m = board.length;
//         int n = board[0].length;
//         int[][]visited= new int[m][n];
//         Queue<int[]> q = new LinkedList<>();
//         int p=0;
//         for(int j=0;j<n;j++){
//           if(board[p][j]=='O'){
//                q.add(new int[]{p,j});
//                visited[p][j]=1;
//         }
//         }
//         int t =0;
//         for(int i=0;i<m;i++ ){
//           if(board[i][t]=='O'){
//                q.add(new int[]{i,t});
//                visited[i][t]=1;
//         }
//         }
//         int r=m-1;
//         for(int j=0;j<n;j++){
//           if(board[r][j]=='O'){
//                q.add(new int[]{r,j});
//                visited[r][j]=1;
//         }
//         }
//         int s =n-1;
//         for(int i=0;i<m;i++){
//           if(board[i][s]=='O'){
//                q.add(new int[]{i,s});
//                visited[i][s]=1;
//         }
//         }
//         for(int  i=0;i<m;i++){
//           for(int j=0;j<n;j++){
//              if(visited[i][j]!=1){
//               visited[i][j]=-1;
//             }
//           }
//         } 
//         int[][]dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
//         while(!q.isEmpty()){
//            int[]cell = q.poll();
//            int x =cell[0];
//            int y= cell[1];
//            for(int[]dirtn:dir){
//              int nx=x+dirtn[0];
//               int ny=y+dirtn[1];
//               if(nx>=0 &&  ny>=0  && nx<m && ny<n && visited[nx][ny]==-1 && board[nx][ny]=='O'){
//                    visited[nx][ny]=1;
//                    q.add(new int[]{nx,ny});
//               }
//            }
//         }
//         for(int  i=0;i<m;i++){
//           for(int j=0;j<n;j++){
//              if(visited[i][j]!=1 && board[i][j]=='O'){
//               visited[i][j]=-1;
//               board[i][j]='X';
//             }
//           }
//         } 
//     }
// }

// with O(1) space complexity
import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add border 'O's to queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                board[i][0] = '#'; // mark visited
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new int[]{i, n - 1});
                board[i][n - 1] = '#';
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.add(new int[]{0, j});
                board[0][j] = '#';
            }
            if (board[m - 1][j] == 'O') {
                queue.add(new int[]{m - 1, j});
                board[m - 1][j] = '#';
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int x = cell[0] + d[0], y = cell[1] + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                    board[x][y] = '#'; 
                    queue.add(new int[]{x, y});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';  // captured
                else if (board[i][j] == '#') board[i][j] = 'O'; // safe
            }
        }
    }
}
