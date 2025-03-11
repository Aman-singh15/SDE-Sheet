/*Given a binary tree having n nodes. Check whether all of its nodes have a value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it returns 0. For every node, the data value must be equal to the sum of the data values in the left and right children. Consider the data value 0 for a NULL child. Also, leaves are considered to follow the property.
Examples:
Input:
Binary tree
       35
      /  \
     20   15
    / \   / \
   15  5 10  5

Output: 1
Explanation: 
Here, every node is sum of its left and right child.
Input:
Binary tree
       1
     /   \
    4     3
   /  
  5    
Output: 0
Explanation: 
Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
Input:
Binary tree
       10
      /  \
     4    6
    / \  / \
   1   3 2  4

Output: 1
Explanation: 
Here, every node is a sum of its left and right child.

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/


class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        boolean ans=helper(root);
        if(ans) return 1;
        return 0;
    }
    
    public static boolean helper(Node root){
        int sum=0;
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        if(root.left!=null){
            sum+=root.left.data;
        }
        if(root.right!=null){
            sum+=root.right.data;
        }
        if(root.data!=sum){
            return false;
        }
        
        return helper(root.left) && helper(root.right);
        // or return 
        //return sum==root.data && helper(root.left) && helper(root.right);
        //both are correct
        
    }
}
