package leetcode.editor.en;

/**
 * Problem : 622
 * Title : Design Circular Queue
 */
class Driver_622 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        private final int[] data;
        private int head, tail;

        public MyCircularQueue(int k) {
            data = new int[k];
            head = tail = -1;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            if (isEmpty()) {
                head++;
                tail++;
            } else {
                tail = (tail + 1) % data.length;
            }
            data[tail] = value;

            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            if (head <= tail) {
                if (++head > tail) {
                    head = tail = -1;
                } else {
                    head %= data.length;
                }
            } else {
                head = (head + 1) % data.length;
            }

            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : data[head];
        }

        public int Rear() {
            return isEmpty() ? -1 : data[tail];
        }

        public boolean isEmpty() {
            return tail == -1;
        }

        public boolean isFull() {
            if (head == tail) {
                if (tail == -1) {
                    return false;
                } else {
                    return 1 == data.length;
                }
            } else {
                return (tail - head + data.length) % data.length + 1 == data.length;
            }
        }
    }
    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
