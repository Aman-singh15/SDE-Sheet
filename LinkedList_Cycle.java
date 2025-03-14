/*Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
  Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //Approach 1:-(Quite Good)
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head==null ||head.next==null){
//             return false;
//         }
//         int pos=Integer.MIN_VALUE;
//         ListNode temp1=head;
//         while(temp1!=null){
//             if(temp1.val==pos){
//                 return true;
//             }else{
//                 temp1.val=pos;
//                 temp1=temp1.next;
//             }
//         }
//         return false;
//     }
// }
// Approach 2:-(with slow and fast)
     public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head==null || head.next==null)
            return false;
        ListNode slow=head;
        ListNode fast=head.next;
    
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
                return true;
            
        }
    
        
        return false;
        
    }
}
