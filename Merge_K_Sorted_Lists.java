/**You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []
Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Approach 1:-(N logN)
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length==0){
//           return null;
//         }
//         PriorityQueue<Integer>pq=new PriorityQueue<>();
//         for(int i=0;i<lists.length;i++){
//            ListNode temp=lists[i];
//            while(temp!=null){
//             pq.offer(temp.val);
//             temp=temp.next;
//            }
//         }
//         ListNode dummy=new ListNode(-1);
//         ListNode ans = dummy;
//         while(!pq.isEmpty()){
//             ans.next=new ListNode(pq.remove());
//             ans=ans.next;
//         }
//         return dummy.next;
//     }
// }

// Approach 2:- O(N logK)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++) {// to optimize we firstly add only head node of the given linked list and later on if this node has more node then add it in min heap.
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while (!pq.isEmpty()) {
            ListNode current = pq.remove();
            ans.next = current;
            ans = ans.next;

            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return dummy.next;
    }
}
