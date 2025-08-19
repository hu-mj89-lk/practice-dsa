package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : 228
 * Title : Summary Ranges
 */
class Driver_228 {
    public static void main(String[] args) {
        List<String> result = new Driver_228().new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            if (nums.length == 0) {
                return List.of();
            } else if (nums.length == 1) {
                return List.of(String.format("%d", nums[0]));
            }

            List<String> result = new ArrayList<>();
            int left = 0, right = 0;
            for (; right + 1 < nums.length; right++) {
                if (nums[right + 1] == (nums[right] + 1)) {
                    continue;
                }

                if (nums[left] == nums[right]) {
                    result.add(String.format("%d", nums[left]));
                } else {
                    result.add(String.format("%d->%d", nums[left], nums[right]));
                }
                left = right + 1;
            }

            if (nums[left] == nums[right]) {
                result.add(String.format("%d", nums[left]));
            } else {
                result.add(String.format("%d->%d", nums[left], nums[right]));
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}