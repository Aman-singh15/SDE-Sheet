/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return buildTreehelper(preorder,inorder,0,preorder.length-1,0,inorder.length);
    }
    public TreeNode buildTreehelper(int[]preorder,int[]inorder,int startpre,int endpre,int startin,int endin){
        if(startpre>endpre){
            return null;
        }
        int rootdata=preorder[startpre];
        TreeNode rootNode= new TreeNode(rootdata);
        int count=-1;
        for(int i=startin;i<=endin;i++){
            if(inorder[i]==rootdata){
                count=i;
                break;
            }
        }
        if(count==-1){
            return null;
        }
        int leftinstart=startin;
        int leftinend=count-1;
        int leftprestart=startpre+1;
        int leftpreend=leftinend-leftinstart + leftprestart;
        int rightprestart=leftpreend+1;
        int rightpreend=endpre;
        int rightinstart=count+1;
        int rightinend=endin;
rootNode.left= buildTreehelper(preorder,inorder,leftprestart,leftpreend,leftinstart,leftinend);
rootNode.right= buildTreehelper(preorder,inorder,rightprestart,rightpreend,rightinstart,rightinend);
              return rootNode;
    }
}
