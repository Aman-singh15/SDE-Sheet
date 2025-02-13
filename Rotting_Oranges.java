/*You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.  */

// Approach 1:- Not Good For higher Test case as it fails to handle
// class Solution {
//     public int orangesRotting(int[][] grid) {
//        // Boolean minuteCount;
//         int minute=0;
//         for(int i=0;i<grid.length;i++){
//           for(int j=0;j<grid[0].length;j++){
//              if(grid[i][j]==2){
//               //  visited[i][j]==true;
//                     Boolean minuteCount=false;
//                 // for right side check
//               if(j+1<grid[0].length && grid[i][j+1]==1){
//                    grid[i][j+1]=2;
//                    if(!minuteCount){
//                    minuteCount=true;
//                    minute++;
//                    }
//                 }
//                 //for left side check
//                 if(j-1>=0 && grid[i][j-1]==1){
//                    grid[i][j-1]=2;
//                    if(!minuteCount){
//                    minuteCount=true;
//                    minute++;
//                    }
//                 }
//                 // for down check
//                 if(i+1<grid.length && grid[i+1][j]==1){
//                   grid[i+1][j]=2;
//                   if(!minuteCount){
//                    minuteCount=true;
//                    minute++;
//                    }
//                 }
//                 // for up check
//                 if(i-1>=0 && grid[i-1][j]==1){
//                   grid[i-1][j]=2;
//                   if(!minuteCount){
//                    minuteCount=true;
//                    minute++;
//                    }
//                 }
                
//              }
//           }
          
//         }
//         for(int i=0;i<grid.length;i++){
//           for(int j=0;j<grid[0].length;j++){
//              if(grid[i][j]==1){
//               return -1;
//              }
//           }
//         }
//         return minute;
//     }
// }

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        // Step 1: Add all rotten oranges to queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // Directions array for 4-directional movement (right, left, down, up)
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 2: Perform BFS level by level
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    // If it's within bounds and is a fresh orange, rot it
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;  // Mark as rotten
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
