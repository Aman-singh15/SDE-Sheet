// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
          if(head==null){
            return head;
          }
        //   if(n==1 && head.next==null){
        //     head=null;
        //     return head;
        //   }
            int length=0;
            ListNode temp=head;
            while(temp!=null){
                temp=temp.next;
                length++;
            }
            int pos=length-n;
             if (pos == 0) {
            return head.next; // Move the head to the next node
        }
            int k=0;
            ListNode temp1=head;
            while(k<pos-1 && temp1!=null){
                temp1=temp1.next;
                k++;
            }
            temp1.next=temp1.next.next;
            return head;

              
    }
}
