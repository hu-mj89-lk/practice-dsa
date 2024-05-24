package leetcode.editor.en;

/**
 * Problem : 1480
 * Title : Running Sum of 1d Array
 */
class Driver_1480 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] runningSum(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] + (i == 0 ? 0 : nums[i - 1]);
            }
            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
