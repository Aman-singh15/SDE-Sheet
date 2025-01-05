/*Given the root of a binary tree, return the inorder traversal of its nodes' values.
Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
Explanation:
Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]/*

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer>ans=new ArrayList<>();
       inorderTraversalhelper(root,ans);
       return ans;
        
    }
    public  void inorderTraversalhelper(TreeNode root,List<Integer>ans){
        if(root==null){
            return;
        }
        inorderTraversalhelper(root.left,ans);
        ans.add(root.val);
         inorderTraversalhelper(root.right,ans);
    }
}
