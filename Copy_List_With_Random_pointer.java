/*A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.
The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]*/


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        //Step 1:-copy nodes in between the two node as a copy of a node
        while(temp!=null){
            Node newNode=new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        temp=head;//temp points to head again
        //Step 2:- connecting random pointer
        while(temp!=null){
            Node newNode=temp.next;//we point to the copy node so that we able to connect its random pointer
            if(temp.random==null){
                newNode.random=null;
            }else{
            newNode.random=temp.random.next;//so that newNode(which is copy)its random points to random of copy list which inserted in between(connects the random pointer)
            }
            temp=temp.next.next;
        }
// Step 3:- Connecting next pointer to extract the copy List(deep copy) and left original List as it is.
          Node dummy=new Node(-1);
        Node ans=dummy;
        temp=head;
        while(temp!=null){
           ans.next=temp.next;//points to copy node
           temp.next=temp.next.next;// points to given original list
           ans=ans.next;
           temp=temp.next;
        }
        return dummy.next;

    }
}
