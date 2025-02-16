/*Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
Example 2:
Input: a = "a", b = "aa"
Output: 2  */


class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder str=new StringBuilder(a);
        int count=1;
        while(str.length() < b.length()){
           str.append(a);
            count++;
        }
        if(str.toString().contains(b)){
             return count;
        }
        // Although if b is not substring of a then append 1 more time a (repeat String)
        str.append(a);
        count++;
         if(str.toString().contains(b)){
             return count;
         }
             return -1;
    }
}
