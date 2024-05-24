package leetcode.editor.en;

/**
 * Problem : 707
 * Title : Design Linked List
 */
class Driver_707 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        Node head;
        int length;

        public MyLinkedList() {
            this.head = null;
            this.length = 0;
        }

        public int get(int index) {
            if (index >= length)
                return -1;

            Node current = null;
            for (int i = 0; i <= index; i++) {
                current = current == null ? head : current.next;
            }

            return current.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(length, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > length)
                return;

            Node node = new Node(val);

            if (index == 0) {
                node.next = head;
                head = node;
            } else {
                Node previous = null;
                for (int i = 0; i <= index - 1; i++) {
                    previous = previous == null ? head : previous.next;
                }

                node.next = previous.next;
                previous.next = node;
            }
            length++;
        }

        public void deleteAtIndex(int index) {
            if (index >= length) {
            } else if (index == 0) {
                head = head.next;
                length--;
            } else {
                Node previous = null;
                for (int i = 0; i <= index - 1; i++) {
                    previous = previous == null ? head : previous.next;
                }

                previous.next = previous.next.next;
                length--;
            }
        }

        private static class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
                this.next = null;
            }
        }
    }
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
