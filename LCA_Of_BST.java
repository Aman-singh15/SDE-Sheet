/*Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.



 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//       if(root==null){
//          return null;
//       }
//         if(root==p || root ==q){
//            return root;
//         }
//         TreeNode left=lowestCommonAncestor(root.left,p,q);
//         TreeNode right=lowestCommonAncestor(root.right,p,q);
//        if(left==null){// if one is null return other side
//          return right;
//        }else if(right==null){
//         return left;
//        }else // both left and right are not null so that's our result
//        return root;
//     }
// }

// Approach 2:-Time complexity:- O(H)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null){
         return root;
      }
      int curr = root.val;
      if(p.val<curr && q.val<curr){// if both p and q is small then root then it found on left
        return lowestCommonAncestor(root.left,p,q);
      }  
      if(p.val>curr && q.val>curr){ 
        return lowestCommonAncestor(root.right,p,q);
      }
      return root;// if they split the path means the root is the common Ancestor (LCA) 
    }
}
