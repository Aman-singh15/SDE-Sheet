/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0
Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/



// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         Arrays.sort(coins);
//         int i = coins.length - 1;
//         int count = 0;   
//         while (i >= 0) {
//             if (coins[i] <= amount) {
//                 int times = amount / coins[i];
//                 count += times;
//                 amount -= coins[i] * times;
//             }
//             i--;
//         }        
//         if (amount == 0) {
//             return count;
//         } else {
//             return -1;
//         }
//     }
// }

// Appraoch:- USing Memoization
class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer storage[][] = new Integer[coins.length][amount + 1];
        int ans = coinMemo(storage, coins, amount, coins.length - 1);
        if (ans >= (int)1e9) return -1;
        return ans;
    }

    public int coinMemo(Integer[][] storage, int[] coins, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        if (index == 0) { 
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else {
                return (int)1e9;
            }
        }

        if (storage[index][amount] != null) {
            return storage[index][amount];
        }

        int notpick = 0 + coinMemo(storage, coins, amount, index - 1);
        int pick = Integer.MAX_VALUE;
        if (amount >= coins[index]) {
            pick = 1 + coinMemo(storage, coins, amount - coins[index], index);
        }

        return storage[index][amount] = Math.min(pick, notpick);
    }
}
