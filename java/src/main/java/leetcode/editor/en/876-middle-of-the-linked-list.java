package leetcode.editor.en;

/**
 * Problem : 876
 * Title : Middle of the Linked List
 */
class Driver_876 {
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
        public ListNode middleNode(ListNode head) {
            ListNode result = head;
            int idx_result = 1;
            ListNode current = head;
            int idx_current = 1;

            while (current != null) {
                int temp = idx_current / 2 + 1;

                if (idx_result != temp) {
                    result = result.next;
                    idx_result = temp;
                }

                current = current.next;
                idx_current++;
            }

            return result;
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
