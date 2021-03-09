/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 第一次遍历时，如果两者的非公共元素的个数正好相等，那么一定能找到相同元素；
 * 如果非公共元素个数不等，那么在一次遍历之后，两者的指针的差距就是非公共元素的个数差。
 * 这样翻转之后，指针的差距正好弥补了非公共元素的差，这样，第二次遍历要么一定相遇，要么两者没有公共元素，返回None。
 * 
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        if ( a == b || (a == null && b == null)) {
            return a;
        } 
        if (a == null || b == null) {
            return null;
        }
        while (a != b ) {
            if (a == null) {
                a = headB;
            }
            else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            }
            else {
                b = b.next;
            }
        }
        return a;
    }
}