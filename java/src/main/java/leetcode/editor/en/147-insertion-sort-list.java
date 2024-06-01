package leetcode.editor.en;

/**
 * Problem : 147
 * Title : Insertion Sort List
 */
class Driver_147 {
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
        public ListNode insertionSortList(ListNode head) {
            ListNode phantom = new ListNode(Integer.MIN_VALUE, head);
            head = phantom;

            ListNode prev = head, curr = head.next;
            while (curr != null) {
                boolean shouldWork = false;
                ListNode prevInner = head;
                while (prevInner.next != curr) {
                    if (prevInner.next.val <= curr.val) {
                        prevInner = prevInner.next;
                    } else {
                        shouldWork = true;
                        break;
                    }
                }

                if (shouldWork) {
                    prev.next = curr.next;
                    curr.next = prevInner.next;
                    prevInner.next = curr;
                    curr = prev.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }

            return phantom.next;
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
