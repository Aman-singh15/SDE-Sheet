/*There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105
Food for thought :
Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.
Example:
Input:[3 1 2 5 3] 
Output:[3, 4] 
A = 3, B = 4   */



// public class Solution {
//     // DO NOT MODIFY THE LIST. IT IS READ ONLY
//     public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
//         ArrayList<Integer>ans=new ArrayList<>();
//         int n=A.size();
//         boolean[]visited=new boolean[n+1];
//         visited[0]=true;
//         for(int i=0;i<A.size();i++){
//            if(!visited[A.get(i)]){
//                 visited[A.get(i)]=true;
//             }else{
//                 ans.add(A.get(i));
//             }
//         }
//         for(int i=1;i<visited.length;i++){
//             if(!visited[i]){
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
// }

// Approach 2:- Using Mathematical formula which takes O(1) time complexity...

public class Solution {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long n = A.size();
        long S_n = (n * (n + 1)) / 2;
        long S2_n = (n * (n + 1) * (2 * n + 1)) / 6;
        long sum_A = 0, sumSq_A = 0;
        
        for (int num : A) {// sum of given array
            sum_A += num;
            sumSq_A += (long) num * num;
        }
        
        long diff1 = sum_A - S_n;         
        long diff2 = sumSq_A - S2_n;  

        long sum = diff2 / diff1;   
        
        int repeated = (int) ((diff1 + sum) / 2);
        int missing = (int) (sum - repeated);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeated);
        ans.add(missing);
        return ans;
    }
}
