/*You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:
Input: root = []
Output: []

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node levelStart = root; // Start from the root node

        while (levelStart != null) {
            Node curr = levelStart;
            Node prev = null; // Keeps track of the previous node in the same level
            levelStart = null; // Reset for the next level

            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) prev.next = curr.left;
                    else levelStart = curr.left; // Update level start if it's the first node
                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev != null) prev.next = curr.right;
                    else levelStart = curr.right; // Update level start if it's the first node
                    prev = curr.right;
                }

                curr = curr.next; // Move to the next node in the same level
            }
        }
        return root;
    }
}
