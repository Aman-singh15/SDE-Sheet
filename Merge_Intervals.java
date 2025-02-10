/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.  */


class Solution {
    public int[][] merge(int[][] intervals) {
          Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
          List<int[]> merged = new ArrayList<>();
          for(int i=0;i<intervals.length;i++){
            int start=intervals[i][0];//storing the first interval
            int end=intervals[i][1];//its end
            for(int j=i+1;j<intervals.length;j++){
               if(end>=intervals[j][0]){
                 end=Math.max(end,intervals[j][1]);
                 i=j;// to skip the merge interval
               }else{
                 break;
               }
            }
             merged.add(new int[]{start, end});
          }
          return merged.toArray(new int[merged.size()][]);

    }
}
