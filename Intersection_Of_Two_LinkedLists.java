// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
//   Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'
// Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Approach 1:- we first find the length of both the list and then move that list 
        //which is longer in length till their difference and then start compairing their node 
        //where the memory address of node match from both the list,that node is our answer.
    //        ListNode temp1=headA;
    //        ListNode temp2=headB;
    //        int count1=0;
    //        int count2=0;
    //        while(temp1!=null){
    //           temp1=temp1.next;
    //           count1++;
    //        }
    //         while(temp2!=null){
    //           temp2=temp2.next;
    //           count2++;
    //        }
    //   // Reset temp1 and temp2 to heads of their respective lists as memory address changes...
    //          temp1 = headA;
    //          temp2 = headB;
    //        int pos=0;
    //        if(count1>count2){
    //           while(pos<(count1-count2)&& temp1!=null){
    //                temp1=temp1.next;
    //                pos++;
    //           }
    //        }else{
    //            while(pos<(count2-count1)&& temp2!=null){
    //                 temp2=temp2.next;
    //                 pos++;
    //            }
    //        }
    //        while(temp1!=null && temp2!=null){
    //             if(temp1==temp2){
    //                 return temp1;
    //             }
    //             temp1=temp1.next;
    //             temp2=temp2.next;
    //        }
    //           return null;
    
    //  Approach 2:-this will bring the list at same length 
            
            ListNode temp1=headA;
            ListNode temp2=headB;
            while(temp1!=temp2){
                if(temp1==null){
                    temp1=headB;
                }else{
                temp1=temp1.next;
                }
                if(temp2==null){
                    temp2=headA;
                }else{
                temp2=temp2.next;
                }
            }
            return temp1;
           
    }
}
