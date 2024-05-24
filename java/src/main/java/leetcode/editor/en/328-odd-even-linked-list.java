package leetcode.editor.en;

/**
 * Problem : 328
 * Title : Odd Even Linked List
 */
class Driver_328 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // @formatter:off
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
    // @formatter:on
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null)
                return head;

            ListNode lo = head;
            ListNode le = head.next;
            ListNode fe = head.next;

            while (le != null && le.next != null) {
                lo.next = le.next;
                lo = lo.next;
                le.next = lo.next;
                le = le.next;
            }
            lo.next = fe;

            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
