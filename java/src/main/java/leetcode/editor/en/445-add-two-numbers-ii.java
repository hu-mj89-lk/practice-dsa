package leetcode.editor.en;

/**
 * Problem : 445
 * Title : Add Two Numbers II
 */
class Driver_445 {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);

            ListNode result = null;

            int carry = 0;
            ListNode prev = null;
            while (l1 != null || l2 != null || carry != 0) {
                int sum = carry;

                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                carry = sum / 10;
                int val = sum % 10;

                ListNode curr = new ListNode(val);

                // initalize result
                if (result == null) {
                    result = curr;
                }

                // move pointers ahead
                if (prev == null) {
                    prev = curr;
                } else {
                    prev.next = curr;
                    prev = curr;
                }
            }

            return reverse(result);
        }

        private ListNode reverse(ListNode node) {
            ListNode prev = null, curr = node;

            while (curr != null) {
                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
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
