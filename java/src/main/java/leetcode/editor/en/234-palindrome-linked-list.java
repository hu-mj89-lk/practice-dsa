package leetcode.editor.en;

/**
 * Problem : 234
 * Title : Palindrome Linked List
 */
class Driver_234 {
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
        public boolean isPalindrome(ListNode head) {
            if (head == null)
                return true;
            else if (head.next == null)
                return true;
            else if (head.next.next == null) {
                return head.val == head.next.val;
            }

            ListNode mid = findMidpoint(head);
            ListNode prevOfMid = previousOfMidpoint(head, mid);
            ListNode reverseMid = reverseList(mid);

            prevOfMid.next = reverseMid;

            ListNode first = head;
            ListNode second = prevOfMid.next;
            while (first != prevOfMid.next) {
                if (first.val != second.val)
                    return false;

                first = first.next;
                second = second.next;
            }

            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }

        private ListNode previousOfMidpoint(ListNode head, ListNode mid) {
            ListNode prevOfMid = null;
            ListNode curr = head;
            while (curr != mid) {
                prevOfMid = curr;
                curr = curr.next;
            }

            return prevOfMid;
        }

        private ListNode findMidpoint(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
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
