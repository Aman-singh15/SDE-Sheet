//Given an integer numRows, return the first numRows of Pascal's triangle.
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        // if(numRows==1){
        //     List<Integer>list=new ArrayList<>();
        //     list.add(1);
        //     ans.add(list);
        //     return ans;
        // }
        //   if(numRows==2){
        //     List<Integer>list=new ArrayList<>();
        //     list.add(1);
        //    ans.add(list);
        //     list=new ArrayList<>();
        //     list.add(1);
        //     list.add(1);
        //     ans.add(list);
        //     return ans;
        // }
         List<Integer> firstRow = new ArrayList<>();
         //First row is always 1
        firstRow.add(1);
        ans.add(firstRow);
        for(int i=1;i<numRows;i++){
            List<Integer>prevRow=ans.get(i-1);//As we have to add the previous row to put it in list
             List<Integer>currRow=new ArrayList<>();
         
             currRow.add(1);//first element of every row is always 1
             for(int j=1;j<prevRow.size();j++){// for finding intermediate values
                currRow.add(prevRow.get(j-1)+prevRow.get(j));
             }
             currRow.add(1);// last element of every row is always 1
             ans.add(currRow);

        }
         

        return ans;
    }
}
