// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
  
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if(head==null || head.next==null || k==0){
//             return head;//If the list is empty or no rotations are needed, return the head.
//         }
//         ListNode temp=head;
//         ListNode temp1=null;// to store the last node.
//         while(temp!=null){
//             if(temp.next!=null && temp.next.next==null){//we use it to find last node
//                 temp1=temp.next;// we store the last node in temp1
//                 temp.next=null;//and de-attach the 2nd last node from the last node by pointing
//                             // it towards null
//             }
//             temp=temp.next;// increment each time temp to temp.next
            
//         }
//         temp=head;// again Reset the temp to head(as memory address changed )
//         temp1.next=temp;//Now,pointing the last node to the temp(head).
//         return rotateRight(temp1,k-1);
//     }
// }
   class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // Handle empty or single-node list, or no rotation.
        }

        // Step 1: Calculate the length of the list
        int length = count(head);

        // Step 2: Optimize k(as,Appraoch 1 fails for higher values of k recursive call grows more)
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Perform rotation recursively
        return rotate(head, k);
    }
     private ListNode rotate(ListNode head, int k) {
        if (k == 0) {
            return head; // no more rotations needed
        }
        ListNode temp=head;
        ListNode temp1=null;// to store the last node.
        while(temp!=null){
            if(temp.next!=null && temp.next.next==null){//we use it to find last node
                temp1=temp.next;// we store the last node in temp1
                temp.next=null;//and de-attach the 2nd last node from the last node by pointing
                            // it towards null
            }
            temp=temp.next;// increment each time temp to temp.next
            
        }
        temp=head;// again Reset the temp to head(as memory address changed )
        temp1.next=temp;
         return rotateRight(temp1,k-1);
     }
      private int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
   }
