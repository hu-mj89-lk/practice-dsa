package leetcode.editor.en;

/**
 * Problem : 1295
 * Title : Find Numbers with Even Number of Digits
 */
class Driver_1295 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumbers(int[] nums) {
            int result = 0;

            for (int num : nums) {
                int digits = 0;

                while (num != 0) {
                    digits++;
                    num = num / 10;
                }

                if (digits % 2 == 0)
                    result++;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
