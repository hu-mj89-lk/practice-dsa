package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Problem : 448
 * Title : Find All Numbers Disappeared in an Array
 */
class Driver_448 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            Map<Integer, Integer> occurrenceMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (!occurrenceMap.containsKey(nums[i]))
                    occurrenceMap.put(nums[i], 1);
            }

            IntStream.range(1, nums.length + 1)
                    .filter(x -> !occurrenceMap.containsKey(x))
                    .forEach(x -> result.add(x));

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
