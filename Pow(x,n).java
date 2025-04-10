/*Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25  */


// class Solution {
//     public double myPow(double x, int n) {
//         if(n==0){
//             return 1;
//         }
//         if(n==1){
//             return x;
//         }
//         if(n>0){
//             double ans=x*myPow(x*x,n/2);
//             or double ans=x*myPow(x,n-1);
//             return ans;
//         }
//         if(n<0){
//               double ans=1/x*myPow(x,n+1);
//               return ans;
//         }
//         return 0;
        
//     }
// }
//But this Approach has some issue at higher level of input as it gives runtime error so,
//to fix them we use Approach 2:-
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n > 0) {
            double ans = myPow(x * x, n / 2);
            if (n % 2 != 0) {
                ans *= x;
            }
            return ans;
        }
        if (n < 0) {
            double ans = myPow(x * x, -(n / 2));
            if (n % 2 != 0) {
                ans *= x;
            }
            return 1 / ans;
        }
        return 0;
    }
}
