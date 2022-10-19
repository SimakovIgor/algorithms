package problems.linkedlist;

import problems.linkedlist.model.ListNode;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val,
 * and return the new head.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            if (cur.val != val) {
                prev = cur;
            } else {
                if (prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
