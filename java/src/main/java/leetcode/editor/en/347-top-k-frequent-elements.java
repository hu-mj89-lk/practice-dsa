package leetcode.editor.en;

import java.util.*;

/**
 * Problem : 347
 * Title : Top K Frequent Elements
 */
class Driver_347 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            return solutionMy(nums, k);
        }

        private int[] solutionMy(int[] nums, int k) {
            // key -> frequency
            Map<Integer, Integer> frequencyTable = new HashMap<>();
            for (int num : nums) {
                if (frequencyTable.containsKey(num)) {
                    frequencyTable.put(num, frequencyTable.get(num) + 1);
                } else {
                    frequencyTable.put(num, 1);
                }
            }

            // frequency -> keys
            Map<Integer, List<Integer>> keyTable = new TreeMap<>((k1, k2) -> k2 - k1);
            for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {
                Integer key = entry.getKey();
                Integer frequency = entry.getValue();
                if (keyTable.containsKey(frequency)) {
                    keyTable.get(frequency).add(key);
                } else {
                    List<Integer> keys = new ArrayList<>();
                    keys.add(key);
                    keyTable.put(frequency, keys);
                }
            }

            int[] result = new int[k];
            Iterator<Map.Entry<Integer, List<Integer>>> iterator = keyTable.entrySet().iterator();
            while (k > 0) {
                for (Integer key : iterator.next().getValue()) {
                    result[--k] = key;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
