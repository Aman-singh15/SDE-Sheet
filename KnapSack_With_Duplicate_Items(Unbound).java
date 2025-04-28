/*Given a set of items, each with a weight and a value, represented by the array wt and val respectively. Also, a knapsack with a weight limit capacity.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.
Examples:
Input: val = [1, 1], wt = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times.
Input: val[] = [6, 1, 7, 7], wt[] = [1, 3, 4, 5], capacity = 8
Output: 48
Explanation: The optimal choice is to pick the 1st element 8 times.
Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
Output: 0
Explanation: We can't pick any element .hence, total profit is 0.
Constraints:
1 <= val.size() = wt.size() <= 1000
1 <= capacity <= 1000
1 <= val[i], wt[i] <= 100
*/

// This is for Bound(singlr pick)knapsack with pick whole eleemnt or not
// class Solution {
//     static int knapSack(int val[], int wt[], int capacity) {
//         // code here
//         Integer[][]storage = new Integer[val.length][capacity+1];
//         return knapsackMemo(storage,val,wt,val.length-1,capacity);
//     }
//     static int knapsackMemo(Integer[][]storage,int val[],int wt[],int index,int maxwt){
//           if(index==0){
//               if(wt[0]<=maxwt){
//                   return val[0];
//               }else{
//                   return 0;
//               }
//           }
//           if(maxwt==0){
//               return 0;
//           }
//           if(storage[index][maxwt]!=null){
//               return storage[index][maxwt];
//           }
//         //   if(wt[index]>maxwt){ That is only correct for 0/1 Knapsack.

//For Unbounded Knapsack, you must handle include and exclude separately!
//         //       return knapsackMemo(storage,val,wt,index-1,maxwt);
//         //   }else{
//               int exclude=knapsackMemo(storage,val,wt,index-1,maxwt);
//               int include = Integer.MIN_VALUE;
//         if (wt[index] <= maxwt) {
//             include = val[index] + knapsackMemo(storage, val, wt, index - 1, maxwt - wt[index]);
//         }
//               return storage[index][maxwt]=Math.max(include,exclude);
          
//     }
// }

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        Integer[][] storage = new Integer[val.length][capacity + 1];
        return knapsackMemo(storage, val, wt, val.length - 1, capacity);
    }

    static int knapsackMemo(Integer[][] storage, int val[], int wt[], int index, int maxwt) {
        if (index == 0) {
            if (wt[0] <= maxwt) {
                return (maxwt / wt[0]) * val[0];
            } else {
                return 0;
            }
        }
        if (storage[index][maxwt] != null) {
            return storage[index][maxwt];
        }

        int notPick = knapsackMemo(storage, val, wt, index - 1, maxwt);

        int pick = Integer.MIN_VALUE;
        if (wt[index] <= maxwt) {
            pick = val[index] + knapsackMemo(storage, val, wt, index , maxwt - wt[index]);
        }

        return storage[index][maxwt] = Math.max(pick, notPick);
    }
}
