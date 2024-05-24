package leetcode.editor.en;

/**
 * Problem : 485
 * Title : Max Consecutive Ones
 */
class Driver_485 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0;

            int counter = 0;
            for (int num : nums) {
                if (num == 1)
                    counter++;
                else {
                    result = Math.max(result, counter);
                    counter = 0;
                }
            }

            result = Math.max(result, counter);

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
