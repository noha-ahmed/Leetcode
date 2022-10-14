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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        
        ListNode fastP = head;
        ListNode middle = head;
        ListNode middlePrev = head;
        while(fastP != null && fastP.next != null){
            middlePrev = middle;
            middle = middle.next;
            fastP = fastP.next.next;
        }
        middlePrev.next = middle.next;
        return head;
    }
}