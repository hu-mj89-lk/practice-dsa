package leetcode.editor.en;

/**
 * Problem : 209
 * Title : Minimum Size Subarray Sum
 */
class Driver_209 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int result = nums.length + 1;
            int left = 0, right = 0, sum = 0;
            while (right < nums.length) {
                if ((sum += nums[right++]) < target) {
                    continue;
                }

                while (left < right) {
                    if (sum - nums[left] < target) {
                        break;
                    }
                    sum -= nums[left++];
                }

                result = Math.min(result, right - left);
            }

            return result > nums.length ? 0 : result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
