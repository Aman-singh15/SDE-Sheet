// Given the head of a singly linked list, return true if it is a 
// palindrome or false otherwise.
// Example 1:
// Input: head = [1,2,2,1]
// Output: true
// Example 2:
// Input: head = [1,2]
// Output: false
  
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
 //Approach 1:-
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode reversehead=reverseList(copyList(head));
//         ListNode temp1 = head;
//         ListNode temp2 = reversehead;

//         while (temp1 != null && temp2 != null) {
//             if (temp1.val != temp2.val) {
//                 return false; // Mismatch found
//             }
//             temp1 = temp1.next;
//             temp2 = temp2.next;
//         }

//         return true; 
//     }

//     public ListNode reverseList(ListNode head){
//         if(head==null || head.next==null){
//             return head;
//         }
//         ListNode reversetail=head.next;
//         ListNode smallhead=reverseList(head.next);
//         reversetail.next=head;
//         head.next=null;
//         return smallhead;
//     }
//      public ListNode copyList(ListNode head) {
//         if (head == null) {
//             return null;
//         }
//         ListNode newHead = new ListNode(head.val);
//         newHead.next = copyList(head.next);
//         return newHead;
//     }
// }
// Approach 2:-
       class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalfHead = reverseList(slow);

        // Step 3: Compare the two halves
        ListNode firstHalfHead = head;
        ListNode secondHalfPointer = secondHalfHead;
        boolean isPalindrome = true;

        while (secondHalfPointer != null) {
            if (firstHalfHead.val != secondHalfPointer.val) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        // Step 4: Restore the list (optional)
        // reverseList(secondHalfHead);

        return isPalindrome;
    }

    // Helper function to reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
