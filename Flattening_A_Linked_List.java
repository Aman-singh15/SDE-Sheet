/*Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom pointer to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.
Note:
1. ↓ represents the bottom pointer and -> represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.
Examples:
Input:
Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
Input:
Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
Explanation:
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
Constraints:
0 <= n <= 100
1 <= number of nodes in sub-linked list(mi) <= 50
1 <= node->data <= 10^4   */



class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
       if(root==null || root.next==null){
            return root;  // i.e. we have reached at last right node so now we send it to merge it to its just before node
       }
       
       root.next=flatten(root.next);
       // before returning the root we will merge it with the last node and similar to left nodes
       root=merge(root,root.next);// so last two go for merge before returning the root
       
       return root;
       
        
    }
    Node merge(Node temp1,Node temp2){
        Node newNode=new Node(0);
        Node temp=newNode;
        
        while(temp1!=null && temp2!=null){
          if(temp1.data<temp2.data){
              temp.bottom=temp1;
              temp1=temp1.bottom;
              temp=temp.bottom;
          }else{
              
              temp.bottom=temp2;
              temp2=temp2.bottom;
              temp=temp.bottom;
          }   
        }
        if(temp1!=null){
            temp.bottom=temp1;
        }else{
            temp.bottom=temp2;
        }
        return newNode.bottom;
    }
}
