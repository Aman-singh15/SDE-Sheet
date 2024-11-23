//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]

class Solution {
    public void setZeroes(int[][] matrix) {
         int rows=matrix.length;
         int column=matrix[0].length;
         boolean zerorows[]=new boolean[rows];
         boolean zerocolumn[]=new boolean[column];
         for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    zerorows[i]=true;
                    zerocolumn[j]=true; 
                }
            }
         }
         for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                if(zerorows[i] || zerocolumn[j]){
                    matrix[i][j]=0;
                }
            }
         }  
    }
}
