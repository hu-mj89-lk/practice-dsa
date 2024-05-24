package leetcode.editor.en;

/**
 * Problem : 21
 * Title : Merge Two Sorted Lists
 */
class Driver_21 {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null)
                return list2;
            else if (list2 == null)
                return list1;

            ListNode head = null;
            ListNode curr = head;
            ListNode curr1 = list1;
            ListNode curr2 = list2;
            while (curr1 != null || curr2 != null) {
                int val1 = curr1 != null ? curr1.val : Integer.MAX_VALUE;
                int val2 = curr2 != null ? curr2.val : Integer.MAX_VALUE;

                ListNode selected = null;
                if (val1 < val2) {
                    selected = curr1;
                    curr1 = curr1.next;
                } else {
                    selected = curr2;
                    curr2 = curr2.next;
                }

                if (curr == null) {
                    head = selected;
                    curr = selected;
                } else {
                    curr.next = selected;
                    curr = curr.next;
                }
            }

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
