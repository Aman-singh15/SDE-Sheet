/*Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.
Examples:
Input: root[] = [1, 2, 3, 4, 5]
ex-3
Output: [[1, 2, 4], [1, 2, 5], [1, 3]] 
Explanation: All possible paths: 1->2->4, 1->2->5 and 1->3
Input: root[] = [1, 2, 3]
       1
    /     \
   2       3
Output: [[1, 2], [1, 3]] 
Explanation: All possible paths: 1->2 and 1->3  */


class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
       ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
       ArrayList<Integer>list=new ArrayList<>();
       list.add(root.data);
       findpath(root,list,ans);
       return ans;
    }
    
    public static void findpath(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>>ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(list));
        }
       if (root.left != null) {
         list.add(root.left.data);
         findpath(root.left, list, ans);
         list.remove(list.size() - 1); // remove last added node after left recursion(Backtracking)
        }
        if(root.right!=null){
          list.add(root.right.data);
          findpath(root.right,list,ans);
          list.remove(list.size()-1);// Backtarck after each recursive step
        }
    }
}
