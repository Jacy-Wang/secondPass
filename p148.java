/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode node = slow.next;
        slow.next = null;
        fast = sortList(head);
        slow = sortList(node);
        
        ListNode dum1 = new ListNode(0);
        dum1.next = fast;
        ListNode dum2 = new ListNode(0);
        dum2.next = slow;
        fast = dum1;
        slow = dum2;
        
        while (fast.next != null && slow.next != null) {
            if (slow.next.val <= fast.next.val) {
                node = fast.next;
                fast.next = slow.next;
                slow.next = slow.next.next;
                fast.next.next = node;
            }
            fast = fast.next;
        }
        if (fast.next == null) {
            fast.next = slow.next;
        }
        return dum1.next;
    }
}
