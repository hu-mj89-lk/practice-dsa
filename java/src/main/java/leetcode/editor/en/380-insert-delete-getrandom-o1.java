package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Problem : 380
 * Title : Insert Delete GetRandom O(1)
 */
class Driver_380 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        private final Map<Integer, Integer> mapData;
        private final ArrayList<Integer> arrData;
        private final Random randomizer;

        public RandomizedSet() {
            this.mapData = new HashMap<>(10_0000);
            this.arrData = new ArrayList<>(10_0000);
            this.randomizer = new Random();
        }

        public boolean insert(int val) {
            boolean containsKey = this.mapData.containsKey(val);
            if (containsKey) {
                return false;
            }

            int idx = arrData.size();
            arrData.addLast(val);
            mapData.put(val, idx);

            return true;
        }

        public boolean remove(int val) {
            boolean containsKey = this.mapData.containsKey(val);
            if (!containsKey) {
                return false;
            }

            int last = this.arrData.getLast();
            int idx = this.mapData.get(val);
            this.arrData.set(idx, last);
            this.mapData.put(last, idx);

            this.mapData.remove(val);
            this.arrData.removeLast();

            return true;
        }

        public int getRandom() {
            int idx = this.randomizer.nextInt(0, arrData.size());
            return this.arrData.get(idx);
        }
    }
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
