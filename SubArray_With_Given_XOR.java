/*Given an array of integers A and an integer B.
Find the total number of subarrays having bitwise XOR of all elements equals to B.
Problem Constraints
1 <= length of the array <= 105
1 <= A[i], B <= 109
Input Format
The first argument given is the integer array A.
The second argument given is integer B.
Output Format
Return the total number of subarrays having bitwise XOR equals to B.
Example Input
Input 1:
 A = [4, 2, 2, 6, 4]
 B = 6
Input 2:
 A = [5, 6, 7, 8, 9]
 B = 5
Example Output
Output 1:
 4
Output 2:
 2
Example Explanation
Explanation 1:
 The subarrays having XOR of their elements as 6 are:
 [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
Explanation 2:
 The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]   */



public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        // Aprroach 1:-(better takes O(n^2))
        // int count=0;
        // int xorSum=0;
        // for(int i=0;i<A.size();i++){
        //     xorSum=0;
        //     for(int j=i;j<A.size();j++){
        //           xorSum^=A.get(j);
        //           if(xorSum==B){
        //               count++;
        //            }
        //     }
        // }
        //     return count;
        
        // this is optimal aprroach takes O(N) time 
        HashMap<Integer,Integer>map= new HashMap<>();
        int count=0;
        int xr=0; // for prefixXor XOR
         map.put(xr,map.getOrDefault(xr,0)+1);//put xr so doing this 
        for(int i=0;i<A.size();i++){
             xr= xr ^ A.get(i);//this and x is serve as formula
            int x= xr ^ B;
            if(map.containsKey(x)){
                count+=map.get(x);
            }
            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return count;
    }
}
