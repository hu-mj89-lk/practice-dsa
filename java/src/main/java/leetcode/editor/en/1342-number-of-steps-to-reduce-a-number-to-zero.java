package leetcode.editor.en;

/**
 * Problem : 1342
 * Title : Number of Steps to Reduce a Number to Zero
 */
class Driver_1342 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSteps(int num) {
            int steps = 0;
            while (num != 0) {
                if (num % 2 == 0)
                    num = num / 2;
                else
                    num = num - 1;

                steps++;
            }

            return steps;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
