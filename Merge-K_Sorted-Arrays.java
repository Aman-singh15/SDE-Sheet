/*Given k sorted arrays arranged in the form of a matrix of size k * k. The task is to merge them into one sorted array. Return the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python).
Examples :
Input: k = 3, arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation: Above test case has 3 sorted arrays of size 3, 3, 3 arr[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]. The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
Input: k = 4, arr[][]={{1,2,3,4},{2,2,3,4},{5,5,6,6},{7,8,9,9}}
Output: 1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted arrays of size 4, 4, 4, 4 arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4], [5, 5, 6, 6], [7, 8, 9, 9 ]]. The merged list will be [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9].
Expected Time Complexity: O(k2*Log(k))
Expected Auxiliary Space: O(k2)
*/


class Solution
{
    //Function to merge k sorted arrays.

  // Method :- 1
     static class Node{
        int value,row,column;
         Node(int value,int row,int column){
            this.value=value;
            this.row=row;
            this.column=column;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
       PriorityQueue<Node>pq= new PriorityQueue<>(Comparator.comparingInt(a -> a.value)); 
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<K;i++){
            pq.offer(new Node (arr[i][0],i,0));
        }
        
        while(!pq.isEmpty()){
            Node curr=pq.poll();
            ans.add(curr.value);
            if(curr.column + 1<K){
                pq.offer(new Node(arr[curr.row][curr.column+1],curr.row,curr.column+1));
            }
        }
            return ans;

      // method 2:-
        // PriorityQueue<Integer>pq= new PriorityQueue<>();
        // ArrayList<Integer>ans = new ArrayList<>();
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         pq.offer(arr[i][j]);
        //     }
        // }
        
        // while(pq.size()>0){
        //     ans.add(pq.remove());
        // }
        // return ans;
    }
}
