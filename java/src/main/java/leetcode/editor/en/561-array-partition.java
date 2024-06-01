package leetcode.editor.en;

import java.util.Arrays;

/**
 * Problem : 561
 * Title : Array Partition
 */
class Driver_561 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrayPairSum(int[] nums) {
            int result = 0;

            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2) {
                result += nums[i];
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
