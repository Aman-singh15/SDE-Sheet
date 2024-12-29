/*Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.
Examples:
Input: arr[] = [2, 3]
Output: [0, 2, 3, 5]
Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
Input: arr[] = [1, 2, 1]
Output: [0, 1, 1, 2, 2, 3, 3, 4]
Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the element 2), and their combinations.*/


import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSums(0, 0, arr, ans);
        return ans;
    }
    // we use pick and not pick method for this
    private void subsetSums(int index, int currentSum, int[] arr, ArrayList<Integer> ans) {
        // Base case: If we've considered all elements
        if (index == arr.length) {
            ans.add(currentSum);
            return;
        }

        // pick
        subsetSums(index + 1, currentSum + arr[index], arr, ans);

        // not pick
        subsetSums(index + 1, currentSum, arr, ans);
    }
}
