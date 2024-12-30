/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]*/
 
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
         sum(candidates,0,0,target,list,ans);
         return ans;
    }
        public void sum(int[] candidates,int currentsum,int index,int target
          ,List<Integer>list,List<List<Integer>>ans){    
      
         if(currentsum==target){
           ans.add(new ArrayList<>(list));
           return;
         }

         if( currentsum>target || index==candidates.length){
            return;
         }

         list.add(candidates[index]);
         // Picking up the index sum
         sum(candidates,currentsum + candidates[index],index+1,target,list,ans);

         list.remove(list.size()-1);// to backtrack
         // using loop to avoid duplicate combinations
         while(index+1<candidates.length && candidates[index]==candidates[index+1]){
                  index++;
         }
         // not picking up the sum
         sum(candidates,currentsum,index+1,target,list,ans);
         
        }
}
