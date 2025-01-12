/*Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. */
 
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//       int max=Integer.MAX_VALUE;
//       int count=1;
//       int n=s.length();
//       HashMap<Character,Integer>map=new HashMap<>();
//         for(int i=0;i<s.length();i++){
//             map.put(s.charAt(i),map.get(s.charAt(i))+1);
//             while(i<n-1 && map.get(s.charAt(i))<2 &&map.get(s.charAt(i+1))<2 && (s.charAt(i)!=charAt(i+1)) ){
//               count++;
//               i++;
//             }
//                if(max<count){
//                     max=count;
//                  }
                    
        
//         }
//         return max;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        int count = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // If character repeats, adjust the starting point `j`
            while (map.get(currentChar) > 1) {
                char startChar = s.charAt(j);
                map.put(startChar, map.get(startChar) - 1);
                j++;
                count--;
            }

            count = i - j + 1; // Update count for the current substring
            max = Math.max(max, count); 
        }
        return max;
    }
}
