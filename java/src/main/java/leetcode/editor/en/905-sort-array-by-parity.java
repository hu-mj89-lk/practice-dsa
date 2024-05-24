package leetcode.editor.en;

/**
 * Problem : 905
 * Title : Sort Array By Parity
 */
class Driver_905 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            if (nums == null || nums.length == 1)
                return nums;

            int evenPtr = 0;
            int readPtr = 0;
            while (readPtr < nums.length) {
                if (nums[readPtr] % 2 == 0) {
                    // swap
                    int temp = nums[evenPtr];
                    nums[evenPtr] = nums[readPtr];
                    nums[readPtr] = temp;

                    evenPtr++;
                }
                readPtr++;
            }

            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
