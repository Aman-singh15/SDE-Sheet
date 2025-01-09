/*You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false*/


// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//    Approach 1:-
//       int r=matrix.length;
//       int c=matrix[0].length;
//       int k=0;
//         int[]arr=new int[r*c];
//         for(int i=0;i<r;i++){
//           for(int j=0;j<c;j++){
//               arr[k]=matrix[i][j];
//               k++;
//           }
//         }
//         for(int i=0;i<arr.length;i++){
//            if(arr[i]==target){
//               return true;
//            }
//         }
//         return false;
//     }
// }
//  Approach 2:-
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;          // Start from the first row
        int col = cols - 1;   // Start from the last column

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;  // Found the target
            } else if (matrix[row][col] > target) {
                col--;        // Move left
            } else {
                row++;        // Move down
            }
        }
        return false;  // Target not found
    }
}
