package leetcode.editor.en;

/**
 * Problem : 708
 * Title : Insert into a Sorted Circular Linked List
 */
class Driver_708 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    */
    class Solution {
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node node = new Node(insertVal);
                node.next = node;
                return node;
            } else if (head.next == head) {
                Node node = new Node(insertVal);
                node.next = head;
                head.next = node;
                return head;
            }

            Node suitableNode = suitableNode(head, insertVal);

            Node node = new Node(insertVal);
            node.next = suitableNode.next;
            suitableNode.next = node;

            return head;
        }

        private Node suitableNode(Node head, int insertVal) {
            Node curr = head;
            Node next = curr.next;
            do {
                int currVal = curr.val;
                int nextVal = next.val;
                if (currVal <= nextVal) {
                    if (currVal <= insertVal && insertVal <= nextVal)
                        return curr;
                } else {
                    if (currVal <= insertVal || insertVal <= nextVal)
                        return curr;
                }

                curr = next;
                next = next.next;
            } while (curr != head);

            return head;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    private static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
