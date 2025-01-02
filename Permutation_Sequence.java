/*The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.
Example 1:
Input: n = 3, k = 3
Output: "213"
Example 2:
Input: n = 4, k = 9
Output: "2314"*/


import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        
        generatePermutations(s.toString().toCharArray(), 0, ans);
        Collections.sort(ans);
        
      //  (1-based index)
        return ans.get(k - 1);
    }

    private void generatePermutations(char[] ch, int index, ArrayList<String> ans) {
        if (index == ch.length) {
            ans.add(new String(ch));
            return;
        }
        
        for (int i = index; i < ch.length; i++) {
            swap(ch, i, index); // Swap characters at i and index
            generatePermutations(ch, index + 1, ans); // Recurse for the next index
            swap(ch, i, index); // backrack
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
