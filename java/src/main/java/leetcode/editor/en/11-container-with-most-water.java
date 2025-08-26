package leetcode.editor.en;

/**
 * Problem : 11
 * Title : Container With Most Water
 */
class Driver_11 {
    public static void main(String[] args) {
        int result = new Driver_11().new Solution().maxArea(new int[]{1, 0, 0, 0, 0, 0, 0, 2, 2});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            // return solutionBF(height);
            return solution1(height);
        }

        /**
         * converge inwards from extreme ends (maxed width) trying to maximize height at the cost of width,
         * verifying progress
         * <p>
         * time complexity : O(n)
         * space complexity : O(1)
         */
        private int solution1(int[] heights) {
            int result = 0;

            int left = 0, right = heights.length - 1;
            do {
                int area = (right - left) * Math.min(heights[left], heights[right]);
                result = Math.max(result, area);
                if (heights[left] > heights[right]) {
                    right--;
                } else {
                    left++;
                }
            } while (left < right);

            return result;
        }

        /**
         * iterate through all combinations finding the maximum.
         * <p>
         * time complexity : O(n^2)
         * space complexity : O(1)
         * <p>
         * TLE
         */
        private int solutionBF(int[] heights) {
            int result = 0;

            for (int l = 0; l < heights.length; l++) {
                for (int r = l + 1; r < heights.length; r++) {
                    result = Math.max(result, Math.min(heights[l], heights[r]) * (r - l));
                }
            }

            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}