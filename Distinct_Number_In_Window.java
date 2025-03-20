/*Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
NOTE:  if B > N, return an empty array.
Input Format
First argument is an integer array A
Second argument is an integer B.
Output Format
Return an integer array.
Example Input
Input 1:
 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:
 A = [1, 1, 2, 2]
 B = 1
Example Output
Output 1:
 [2, 3, 3, 2]
Output 2:
 [1, 1, 1, 1]
Example Explanation
Explanation 1:
 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:
 Window size is 1, so the output array is [1, 1, 1, 1].
*/

// Approach 1:- Brute force takes  O(N * B) time B of map
// public class Solution {
//     public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
//          if(B > A.size()){
//              return new ArrayList<Integer>(); 
//          }
//          ArrayList<Integer>list = new ArrayList<>();
//          for(int i=0;i<=A.size()-B;i++){
//             HashMap<Integer,Integer>map=new HashMap<>();
//              for(int j=i;j<i+B;j++){
//                  if(map.containsKey(A.get(j))){
//                      continue;
//                  }else{
//                      map.put(A.get(j),1);
//                  }
//              }
//              list.add(map.size());
//          }
//          return list;
//     }
// }


// Approach 2:- ✅ Time Complexity: O(N) (Each element is processed once in the sliding window)
//✅ Space Complexity: O(B) (HashMap stores at most B elements)


public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
         if (B > A.size()) {
             return new ArrayList<Integer>(); 
         }
         ArrayList<Integer> list = new ArrayList<>();
         HashMap<Integer, Integer> map = new HashMap<>();

         // Build the initial window
         for (int i = 0; i < B; i++) {
             map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
         }
         list.add(map.size());

         // Slide the window
         for (int i = B; i < A.size(); i++) {
             // Remove the element that goes out of the window
             int outgoing = A.get(i - B);
             if (map.get(outgoing) == 1) {
                 map.remove(outgoing);
             } else {
                 map.put(outgoing, map.get(outgoing) - 1);
             }

             // Add the new element to the window
             int incoming = A.get(i);
             map.put(incoming, map.getOrDefault(incoming, 0) + 1);

             // Store the count of distinct numbers
             list.add(map.size());
         }
         return list;
    }
}
