/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Check if there are at least k nodes
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            // Reverse first k nodes
            ListNode prev = reverse(head, k);

            // Recursively reverse remaining list
            head.next = reverseKGroup(curr, k);

            return prev;
        }

        return head;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
