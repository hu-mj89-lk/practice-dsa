package leetcode.editor.en;

/**
 * Problem : 977
 * Title : Squares of a Sorted Array
 */
class Driver_977 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];

            int left = 0;
            int right = nums.length - 1;

            for (int i = nums.length - 1; i >= 0; i--) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    result[i] = nums[left] * nums[left];
                    left++;
                } else {
                    result[i] = nums[right] * nums[right];
                    right--;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
