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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        {
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode secound = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(secound!=null){
            ListNode next = secound.next;
            secound.next=prev;
            prev=secound;
            secound=next;
        }
         ListNode first=head;
          secound=prev;

        while(secound!=null){
            ListNode temp1=first.next;
            ListNode temp2=secound.next;
            
            first.next=secound;
            secound.next=temp1;
            
            first=temp1;
            secound=temp2;


        }
    }
}
