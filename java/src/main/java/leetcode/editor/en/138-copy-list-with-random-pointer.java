package leetcode.editor.en;

/**
 * Problem : 138
 * Title : Copy List with Random Pointer
 */
class Driver_138 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;

            Node newHead = null;

            // duplicate originial nodes with data and pointers to original nodes
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                Node random = curr.random;

                Node node = new Node(curr.val);
                node.next = next;
                node.random = random;

                curr.next = node;

                curr = next;
            }

            newHead = head.next;

            // update random pointers in duplicate nodes
            curr = head;
            while (curr != null) {
                Node newCurr = curr.next;

                if (newCurr.random != null)
                    newCurr.random = newCurr.random.next;

                curr = newCurr.next;
            }

            // separate out both lists
            curr = head;
            Node newCurr = newHead;
            while (curr != null) {
                curr.next = newCurr.next;
                if (newCurr.next != null)
                    newCurr.next = newCurr.next.next;

                curr = curr.next;
                newCurr = newCurr.next;
            }

            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
