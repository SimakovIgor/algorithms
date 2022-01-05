package algorithms;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Ex
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * Input: head = []
 * Output: []
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
