package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 169
 * Title : Majority Element
 */
class Driver_169 {
    public static void main(String[] args) {
        int result = new Driver_169().new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            return solution1(nums);
        }

        /**
         * uses frequency table
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private int solution1(int[] nums) {
            Map<Integer, Integer> frequency = new HashMap<>();

            for (int num : nums) {
                if (frequency.containsKey(num)) {
                    frequency.put(num, frequency.get(num) + 1);
                } else {
                    frequency.put(num, 1);
                }
            }

            return frequency.entrySet().stream()
                    .filter(entry -> entry.getValue() > (nums.length >> 1))
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElse(Integer.MIN_VALUE);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}