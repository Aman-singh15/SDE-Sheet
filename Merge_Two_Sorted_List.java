You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
  
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
           if(list1==null){
            return list2;
           }
           if(list2==null){
            return list1;
           }
//            ListNode head1=list1;
//            ListNode head2=list2;
//            ListNode finalhead=null;
//            ListNode finaltail=null;
//            if(head1.val<=head2.val){
//                  finalhead=head1;
//                  finaltail=head1;
//                  head1=head1.next;
//            }else{
//             finalhead=head2;
//             finaltail=head2;
//             head2=head2.next;
//            }
//            while(head1!=null && head2!=null){
//             if(head1.val<=head2.val){
//                 finaltail.next=head1;
//                 finaltail=head1;
//                 head1=head1.next;
//             }else{
//                 finaltail.next=head2;
//                 finaltail=head2;
//                 head2=head2.next;
//             }
//            }
//            if(head1!=null){
//                finaltail.next=head1;
//            }else{
//             finaltail.next=head2;
//            }
//               return finalhead;
//     }
// }
        if(list1.val<=list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
        
        if(list1.val>list2.val){
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
        return list1;
    }
}

