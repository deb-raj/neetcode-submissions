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
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(true) {

            ListNode kth=prev;
            
    for(int i = 0; i < k; i++) {
        kth = kth.next;

        if(kth == null) {
            return dummy.next;
        }
    }

            ListNode groupStart = prev.next;
            ListNode groupNext = kth.next;

            ListNode curr = groupStart;
            ListNode reversePrev = groupNext;

            while(curr != groupNext) {

                ListNode next = curr.next ;
                curr.next=reversePrev;
                reversePrev=curr;
                curr=next;
            }
            prev.next=kth;
            prev= groupStart;

        }
       
    }
}
