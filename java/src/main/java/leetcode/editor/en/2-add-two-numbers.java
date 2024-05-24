package leetcode.editor.en;

/**
 * Problem : 2
 * Title : Add Two Numbers
 */
class Driver_2 {
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
            ListNode result = null;

            int carry = 0;
            ListNode curr = result;
            while (l1 != null || l2 != null || carry > 0) {
                int d1 = l1 != null ? l1.val : 0;
                int d2 = l2 != null ? l2.val : 0;

                int sum = d1 + d2 + carry;

                int digit = sum % 10;
                carry = sum / 10;

                ListNode d = new ListNode(digit);
                if (result == null) {
                    result = d;
                    curr = d;
                } else {
                    curr.next = d;
                    curr = curr.next;
                }

                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
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
