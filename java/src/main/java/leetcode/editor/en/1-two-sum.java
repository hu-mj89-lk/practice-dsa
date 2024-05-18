package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 1
 * Title : Two Sum
 */
class Driver_1 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int other;
                if (map.containsKey((other = target - nums[i])))
                    return new int[]{i, map.get(other)};
                else
                    map.put(nums[i], i);
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
