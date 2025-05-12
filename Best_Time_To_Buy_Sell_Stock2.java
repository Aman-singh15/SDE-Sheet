/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 
Constraints:
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
*/



// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit = 0;
//         for (int i = 1; i < prices.length; i++) {
//             if (prices[i] > prices[i - 1]) {
//                 profit += prices[i] - prices[i - 1];
//             }
//         }
//         return profit;
//     }
// }


// approach 2:- Using Memoization
class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       Integer[][]storage = new Integer[n][2];// 2- to show buy 1 to buy 0 to sell or not buy
       return memoprofit(storage,prices,0,1);
    }
    public int memoprofit(Integer[][]storage,int prices[],int index,int buy){
         if(index== prices.length){
           return 0;
         }
         if(storage[index][buy]!=null){
           return storage[index][buy];
         }
         int profit;
         if(buy==1){
           int pickprofit =-prices[index]+ memoprofit(storage,prices,index+1,0);//we use -price[i] because,when we buy a stock, we are paying money (spending), so it's a negative profit at that moment.
//We subtract the stock price because it reduces our total profit.
           int notpickprofit = 0 +  memoprofit(storage,prices,index+1,1);
            profit = Math.max(pickprofit,notpickprofit);
         }else{
           int pick = prices[index]+ memoprofit(storage,prices,index+1,1);
            int notpick = 0 +  memoprofit(storage,prices,index+1,0);
              profit = Math.max(pick,notpick);
         }
         return storage[index][buy]= profit;
    }
}
