package leetcode.editor.en;

/**
 * Problem : 19
 * Title : Remove Nth Node From End of List
 */
class Driver_19 {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while (n != 0) {
                fast = fast.next;
                n--;
            }

            ListNode previous = null;
            ListNode slow = head;
            while (fast != null) {
                previous = slow;
                slow = slow.next;
                fast = fast.next;
            }

            if (previous == null)
                head = head.next;
            else
                previous.next = previous.next.next;

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
