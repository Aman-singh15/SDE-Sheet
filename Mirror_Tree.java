/*Given a binary tree, convert the binary tree to its Mirror tree.
Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.     
Examples:
Input: root[] = [1, 2, 3, N, N, 4]
Output: [1, 3, 2, N, 4]
Explanation: 
In the inverted tree, every non-leaf node has its left and right child interchanged.
Input: root[] = [1, 2, 3, 4, 5]
Output: [1, 3, 2, N, N, 5, 4]
Explanation:
In the inverted tree, every non-leaf node has its left and right child interchanged.
*/



// User function Template for Java
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if(node==null){
            return;
        }
        if(node.left!=null || node.right!=null){
            Node temp=node.left;
            node.left=node.right;
            node.right=temp;
        }
        mirror(node.left);
        mirror(node.right);
    }
}
