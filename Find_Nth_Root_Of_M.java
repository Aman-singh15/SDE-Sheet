/*Problem statement
You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.
Note:
'nth' root of an integer 'm' is a number, which, when raised to the power 'n', gives 'm' as a result.
Example:
Input: ‘n’ = 3, ‘m’ = 27
Output: 3
Explanation: 
3rd Root of 27 is 3, as (3)^3 equals 27.   */


public class Solution {
    public static int NthRoot(int n, int m) {
        int start = 1, end = m;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            double power = Math.pow(mid,n); 
            
            if (power == m) {
                return mid;
            } else if (power > m) {
                end= mid - 1;
            } else {
                start = mid + 1; 
            }
        }
        
        return -1; // no integer root found
    }
}
