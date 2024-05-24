package leetcode.editor.en;

/**
 * Problem : 283
 * Title : Move Zeroes
 */
class Driver_283 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 1)
                return;

            int writePtr = 0;
            int readPtr = 0;
            while (readPtr < nums.length) {
                if (nums[readPtr] != 0) {
                    int temp = nums[writePtr];
                    nums[writePtr] = nums[readPtr];
                    nums[readPtr] = temp;
                    writePtr++;
                }
                readPtr++;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
