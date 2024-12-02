/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]*/

  
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode ans = null;
        ListNode prevTail = null; // To connect previous group's tail to the current group's head
        int length = count(head);

        while (length >= k) { // Reverse only when there are enough nodes
            ListNode temp1 = temp;
            ListNode prev = null; // For reversing the group
            int pos = 0;

            // Reverse k nodes
            while (pos < k && temp != null) {
                ListNode nextNode = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nextNode;
                pos++;
            }

            if (ans == null) { // Set the head of the answer list
                ans = prev;
            }

            if (prevTail != null) { // Connect the previous group's tail to the current group's head
                prevTail.next = prev;
            }

            prevTail = temp1; // Update the tail for the current group
            length -= k; // Reduce the length by k
        }

        // Connect the remaining nodes (if any) as-is
        if (prevTail != null) {
            prevTail.next = temp;
        }

        return ans;
    }

    // Helper function to count the length of the list
    public int count(ListNode head1) {
        int count = 0;
        while (head1 != null) {
            count++;
            head1 = head1.next;
        }
        return count;
    }
}
