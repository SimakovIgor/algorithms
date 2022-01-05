package algorithms.linkedlist;

import algorithms.linkedlist.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
 * connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Ex's:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        Set set = new HashSet();
        set.add(head);

        while (head.next != null) {
            if (set.contains(head.next))
                return true;
            head = head.next;
            set.add(head);
        }

        return false;
    }
}


