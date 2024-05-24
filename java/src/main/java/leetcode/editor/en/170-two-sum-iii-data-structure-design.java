package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Problem : 170
 * Title : Two Sum III - Data structure design
 */
class Driver_170 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TwoSum {
        private final Map<Integer, Integer> data;

        public TwoSum() {
            this.data = new HashMap<>();
        }

        public void add(int number) {
            data.put(number, data.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            Set<Map.Entry<Integer, Integer>> entries = data.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                int curr = entry.getKey();
                int compliment = value - curr;

                if ((curr != compliment && data.containsKey(compliment))
                        || (curr == compliment && entry.getValue() > 1))
                    return true;
            }

            return false;
        }
    }
    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
