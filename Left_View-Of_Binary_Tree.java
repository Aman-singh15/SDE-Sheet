/*You are given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.
If the tree is empty, return an empty list.
Examples :
Input: root[] = [1, 2, 3, 4, 5, N, N]
Output: [1, 2, 4]
Explanation: From the left side of the tree, only the nodes 1, 2, and 4 are visible.
Input: root[] = [1, 2, 3, N, N, 4, N, N, 5, N, N]
Output: [1, 2, 4, 5]
Explanation: From the left side of the tree, the nodes 1, 2, 4, and 5 are visible.
Input: root[] = [N]
/*



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
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
       if(root==null){
           return new ArrayList<>();
       }
       ArrayList<Integer>ans=new ArrayList<>();
       
       // Using BFS
       Queue<Node>queue=new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
        int size=queue.size();
           for(int i=0;i<size;i++){
               Node curr=queue.poll();
               if(i==0){// it gives the first node of the level, add to answer list
                   ans.add(curr.data);
               }
               if(curr.left!=null){
                   queue.offer(curr.left);
               }
               if(curr.right!=null){
                   queue.offer(curr.right);
               }
           }
       }
       return ans;
       
       // Using DFS
    //   helper(root,ans,0);
    //   return ans;
    // }
    // void helper(Node root, ArrayList<Integer>ans,int level){
    //     if(root==null){
    //         return;
    //     }
    //   if(ans.size()==level){
    //       ans.add(root.data);
    //   }
    //   helper(root.left,ans,level+1);
    //   helper(root.right,ans,level+1);
     }
}
