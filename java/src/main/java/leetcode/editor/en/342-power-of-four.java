package leetcode.editor.en;

/**
 * Problem : 342
 * Title : Power of Four
 */
class Driver_342 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour(int n) {
            return solutionNaive(n);
        }

        private boolean solutionNaive(int n) {
            if (n <= 0)
                return false;
            if (n == 1)
                return true;

            while ((n % 4) == 0) {
                n >>= 2;
                if (n >= 4)
                    continue;

                return n == 1;
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}