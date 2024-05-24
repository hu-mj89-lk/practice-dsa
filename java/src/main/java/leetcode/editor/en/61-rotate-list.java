package leetcode.editor.en;

/**
 * Problem : 61
 * Title : Rotate List
 */
class Driver_61 {
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
        public ListNode rotateRight(ListNode head, int k) {
            int len = length(head);
            if (len < 2)
                return head;

            int j = k % len;
            if (j == 0)
                return head;

            return rotateInternal(head, len, j);
        }

        private ListNode rotateInternal(ListNode head, int len, int j) {
            ListNode fast = head, slow = head;
            int pos = 1;
            while (fast != null) {
                if (pos < (len - j)) {
                    slow = slow.next;
                    pos++;
                }

                if (fast.next == null)
                    break;
                else
                    fast = fast.next;
            }

            ListNode result = slow.next;
            slow.next = null;
            fast.next = head;

            return result;
        }

        private int length(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }

            return len;
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
