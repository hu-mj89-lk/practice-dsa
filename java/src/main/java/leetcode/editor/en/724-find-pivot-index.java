package leetcode.editor.en;

/**
 * Problem : 724
 * Title : Find Pivot Index
 */
class Driver_724 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
            }

            int left = 0, right = total;
            for (int j = 0; j < nums.length; j++) {
                left = j == 0 ? 0 : left + nums[j - 1];
                right = j == nums.length - 1 ? 0 : right - nums[j];

                if (left == right)
                    return j;
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
