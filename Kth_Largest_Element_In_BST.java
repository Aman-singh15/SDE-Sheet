/*Given a Binary Search Tree. Your task is to complete the function which will return the kth largest element without doing any modification in the Binary Search Tree.
Examples:
Input:
      4
    /   \
   2     9
k = 2 
Output: 4
Explanation: 2nd Largest element in BST is 4
Input:
       9
        \ 
          10
k = 1
Output: 10
Explanation: 1st Largest element in BST is 10
Input:
      4
    /   \
   2     9
k = 3 
Output: 2
Explanation: 3rd Largest element in BST is 2


class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    int count=0;
    int ans=-1;
    public int kthLargest(Node root, int k) {
        // Your code here
     
        helper(root,k);
        return ans;
        
    }
    public void helper(Node root,int k){
        if(root==null){
            return ;
        }
        helper(root.right,k);
        count++;
        if(count==k){
           ans=root.data;
        }
        helper(root.left,k);
    }
}
