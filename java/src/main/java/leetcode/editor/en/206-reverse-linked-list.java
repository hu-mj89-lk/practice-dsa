package leetcode.editor.en;

/**
 * Problem : 206
 * Title : Reverse Linked List
 */
class Driver_206 {
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
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;

            ListNode previous = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;

                curr.next = previous;

                previous = curr;
                curr = next;
            }

            return previous;
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
