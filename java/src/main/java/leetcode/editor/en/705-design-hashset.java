package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : 705
 * Title : Design HashSet
 */
class Driver_705 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        private final int MAX_LEN = 10000;
        private final List<Integer>[] data;

        public MyHashSet() {
            this.data = new ArrayList[MAX_LEN];
        }

        private int hash(int key) {
            return key % data.length;
        }

        private int getIndex(int key, List<Integer> bucket) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i) == key)
                    return i;
            }
            return -1;// not found
        }

        public void add(int key) {
            int hash = hash(key);
            List<Integer> bucket = data[hash];
            if (bucket == null) {
                bucket = data[hash] = new ArrayList<>();
            }
            int idx = getIndex(key, bucket);
            if (idx < 0)
                bucket.add(key);
        }

        public void remove(int key) {
            int hash = hash(key);
            List<Integer> bucket = data[hash];
            if (bucket == null) {
                bucket = data[hash] = new ArrayList<>();
            }

            int idx;
            if ((idx = getIndex(key, bucket)) < 0)
                return;
            bucket.remove(idx);
        }

        public boolean contains(int key) {
            int hash = hash(key);
            List<Integer> bucket = data[hash];
            if (bucket == null) {
                return false;
            }

            return getIndex(key, bucket) >= 0;
        }
    }
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
