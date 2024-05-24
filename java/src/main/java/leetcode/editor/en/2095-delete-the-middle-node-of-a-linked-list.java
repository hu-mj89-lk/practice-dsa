package leetcode.editor.en;

/**
 * Problem : 2095
 * Title : Delete the Middle Node of a Linked List
 */
class Driver_2095 {
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
        public ListNode deleteMiddle(ListNode head) {

            if (head == null || head.next == null)
                return null;

            ListNode previous = head;
            ListNode slow = head;
            int idx_slow = 1;
            ListNode fast = head;
            int idx_fast = 1;

            while (fast != null) {
                int temp = idx_fast / 2 + 1;

                if (idx_slow != temp) {
                    previous = slow;
                    slow = slow.next;
                    idx_slow = temp;
                }

                fast = fast.next;
                idx_fast++;
            }

            previous.next = slow.next;

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
