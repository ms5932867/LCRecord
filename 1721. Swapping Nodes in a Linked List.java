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
    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int val1 = -1;
        int val2 = -1;
        while(head != null) {
            length++;
            if (length == k) {
                val1 = head.val;
                // System.out.println("val1 = " + val1);
            }
            head = head.next;
        }
        int index2 = length - k + 1;
        length = 0;
        head = dummy.next;
        // System.out.println("head.val = " + head.val);
        while(head != null) {
            length++;
            if (length == index2) {
                val2 = head.val;
                head.val = val1;
                System.out.println(head.val);
            }
            head = head.next;
        }
        head = dummy.next;
        length = 0;
        while(head != null) {
            length++;
            if (length == k) {
                head.val = val2;
                System.out.println(head.val);
                break;
            }
            head = head.next;
        }
        return dummy.next;
    }
}