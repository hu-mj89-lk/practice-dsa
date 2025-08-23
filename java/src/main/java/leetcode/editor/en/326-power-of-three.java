package leetcode.editor.en;

/**
 * Problem : 326
 * Title : Power of Three
 */
class Driver_326 {
    public static void main(String[] args) {
        boolean result = new Driver_326().new Solution().isPowerOfThree(9);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree(int n) {
            return solution1(n);
        }

        /**
         * followup question
         */
        private boolean solution2(int n) {
            // TODO : implement
            return false;
        }

        /**
         * uses loops
         * <p>
         * time complexity : O(log(n))
         * space complexity : O(1)
         */
        private boolean solution1(int n) {
            if (n <= 0)
                return false;

            while (n > 1 && ((n % 3) == 0)) {
                n /= 3;
            }

            return n == 1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}