package leetcode.editor.en;

/**
 * Problem : 160
 * Title : Intersection of Two Linked Lists
 */
class Driver_160 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // @formatter:off
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    // @formatter:on
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = length(headA);
            int lengthB = length(headB);

            ListNode newHeadA = headA;
            ListNode newHeadB = headB;
            if (lengthA > lengthB) {
                newHeadA = moveHead(headA, lengthA - lengthB);
                newHeadB = headB;
            } else if (lengthB > lengthA) {
                newHeadA = headA;
                newHeadB = moveHead(headB, lengthB - lengthA);
            }

            while (newHeadA != null && newHeadB != null) {
                if (newHeadA == newHeadB)
                    return newHeadA;

                newHeadA = newHeadA.next;
                newHeadB = newHeadB.next;
            }

            return null;
        }

        private int length(ListNode start) {
            int length = 0;
            while (start != null) {
                start = start.next;
                length++;
            }

            return length;
        }

        private ListNode moveHead(ListNode head, int count) {
            while (count != 0 && head != null) {
                head = head.next;
                count--;
            }

            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
