package leetcode.editor.en;

/**
 * Problem : 268
 * Title : Missing Number
 */
class Driver_268 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            return solution1(nums);
        }

        /**
         * uses sum of arithmetic progression
         * <p>
         * time complexity : O(n)
         * space complexity : O(1)
         */
        private int solution1(int[] nums) {
            int n = nums.length;

            // sum of range [0,n]
            int sumOfRange = (n * (n + 1)) >> 1;

            int sumOfArray = 0;
            for (int num : nums) {
                sumOfArray += num;
            }

            return sumOfRange - sumOfArray;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}