package leetcode.editor.en;

/**
 * Problem : 430
 * Title : Flatten a Multilevel Doubly Linked List
 */
class Driver_430 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    */
    class Solution {
        public Node flatten(Node head) {
            flattenInternal(head);
            return head;
        }

        private Node flattenInternal(Node head) {
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                Node child = curr.child;

                if (child == null) {
                    prev = curr;
                    curr = curr.next;
                    continue;
                }

                Node last = flattenInternal(curr.child);

                curr.next = child;
                child.prev = curr;
                curr.child = null;

                if (next != null) {
                    next.prev = last;
                    last.next = next;
                }

                prev = last;
                curr = next;
            }

            return prev;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
