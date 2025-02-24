/*Given a string s, return the longest palindromic substring in s.
Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"  */


class Solution {
    public String longestPalindrome(String s) {
        String longest="";
        for(int i=0;i<s.length();i++){
          for(int j=i;j<s.length();j++){
            String current = s.substring(i, j + 1);
                if (ispalindrome(current) && current.length() > longest.length()) {
                    longest = current;
                }
          }
        }
        return longest;
    }
    public boolean ispalindrome(String s){
      // int n = s.length();
      // for (int i = 0; i < n / 2; i++) {
      //   if (s.charAt(i) != s.charAt(n - 1 - i)) {
      //       return false;
      //   }
      // }
    
      //  return true;
       int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
