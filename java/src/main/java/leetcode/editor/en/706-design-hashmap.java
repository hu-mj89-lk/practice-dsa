package leetcode.editor.en;

/**
 * Problem : 706
 * Title : Design HashMap
 */
class Driver_706 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        private static class Node {
            private final int key;
            private int value;
            private Node next;

            private Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int MAX_LEN = 10000;
        private final Node[] data;

        public MyHashMap() {
            this.data = new Node[MAX_LEN];
        }

        private int hash(int key) {
            return key % data.length;
        }

        public void put(int key, int value) {
            int hash = hash(key);
            Node node;
            if ((node = data[hash]) == null) {
                data[hash] = new Node(key, value);
                return;
            } else if (node.key == key) {
                node.value = value;
                return;
            }

            while (node.next != null) {
                if (node.next.key == key) {
                    node.next.value = value;
                    return;
                }
                node = node.next;
            }

            node.next = new Node(key, value);
        }

        public int get(int key) {
            int hash = hash(key);
            Node node;
            if ((node = data[hash]) == null)
                return -1;

            while (node != null) {
                if (node.key == key)
                    return node.value;

                node = node.next;
            }

            return -1;
        }

        public void remove(int key) {
            int hash = hash(key);
            Node node;
            if ((node = data[hash]) == null)
                return;
            else if (node.key == key) {
                data[hash] = node.next;
                return;
            }

            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }
    }
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}
