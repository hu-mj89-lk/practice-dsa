package leetcode.editor.en;

/**
 * Problem : 747
 * Title : Largest Number At Least Twice of Others
 */
class Driver_747 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dominantIndex(int[] nums) {
            int largest = largest(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i != largest && nums[largest] < 2 * nums[i])
                    return -1;
            }

            return largest;
        }

        private int largest(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[result])
                    result = i;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
