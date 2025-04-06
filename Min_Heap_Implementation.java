/*Problem statement
Implement the Min Heap data structure.
You will be given 2 types of queries:-
0 X
Insert X in the heap.
1
Print the minimum element from the heap and remove it.

Constraints :
1 <= T <= 5
1 <= N <= 10^5
1 <= X <= 50
Time Limit: 1 sec
Sample Input 1 :
2
3
0 2
0 1
1
2
0 1
1
Sample Output 1 :
1
1
Explanation Of Sample Input 1 :
For the first test case:-
Insert 2 in the heap and currently, 2 is the smallest element in the heap.
Insert 1 in the heap and now the smallest element is 1.
Return and remove the smallest element which is 1.

For the second test case:-
Insert 1 in the heap and currently, 1 is the smallest element in the heap.
Return the smallest element from the heap which is 1 and remove it.
Sample Input 2 :
2
5
0 5
1
0 43
0 15
0 5
2
0 4
1
*/
// Time complexity:- O(n logn)
import java.util.* ;
import java.io.*; 
public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
       PriorityQueue<Integer>pq= new PriorityQueue<>();
       ArrayList<Integer>list = new ArrayList<>();
       for(int i=0;i<q.length;i++){
           if(q[i][0]==0){
               pq.offer(q[i][1]);
           }
           if(q[i][0]==1  && !pq.isEmpty()){
             list.add(pq.remove());
           }
       }

       int arr[]=new int[list.size()];
       for(int i=0;i<arr.length;i++){
           arr[i]=list.get(i);
       }
        return arr;
    }
}
