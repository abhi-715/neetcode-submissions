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

        if(head == null) 
            return;
        ListNode slowPtr = splitList(head);
        ListNode head2 = slowPtr;
        slowPtr = null;
        ListNode reversedList = reverseList(head2);
        mergeLists(head, reversedList);
        
    }

    ListNode splitList(ListNode head){
        ListNode node = head;
        ListNode slowPtr = node;
        ListNode fastPtr = node;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;

    }

    ListNode reverseList(ListNode ptr){
        ListNode prev = null;
        ListNode current = ptr;
        ListNode next = ptr;

        while(current!= null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    ListNode mergeLists(ListNode head1, ListNode head2){
        
        ListNode current1 = head1;
        ListNode current2 = head2;

        while(current2.next != null){

            ListNode next1 = current1.next;
            ListNode next2 = current2.next;

            current1.next = current2;
            current2.next = next1;

            current1 = next1;
            current2 = next2;
        }
        return head1;

    }
}
