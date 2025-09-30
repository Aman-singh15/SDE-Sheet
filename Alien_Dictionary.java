/*A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.
Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.
However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").
A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.
Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.
Examples:
Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
Input: words[] = ["caa", "aaa", "aab"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "cab".
The pair "caa" and "aaa" suggests 'c' appears before 'a'.
The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary. 
So, 'c' → 'a' → 'b' is a valid ordering.
Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: No valid ordering of letters is possible.
The pair "ab" and "ef" suggests "a" appears before "e".
The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.
Constraints:
1 ≤ words.length ≤ 500
1 ≤ words[i].length ≤ 100
words[i] consists only of lowercase English letters.
*/



class Solution {
    public String findOrder(String[] words) {
        int n = words.length;
        Integer[][] graph = new Integer[26][26];
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];

        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                present[s.charAt(j) - 'a'] = true;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return ""; 
            }

            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';
                    if (graph[u][v] == null) { 
                        graph[u][v] = 1;
                        indegree[v]++;
                    }
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append((char)(node + 'a'));
            count++;

            for (int i = 0; i < 26; i++) {
                if (graph[node][i] != null) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (present[i] && sb.indexOf("" + (char)(i + 'a')) == -1) {
                return ""; 
            }
        }

        return sb.toString();
    }
}
