package leetcode.editor.en;

/**
 * Problem : 3195
 * Title : Find the Minimum Area to Cover All Ones I
 */
class Driver_3195 {
    public static void main(String[] args) {
        int result = new Driver_3195().new Solution().minimumArea(new int[][]{
                {0, 1, 0},
                {1, 0, 1}
        });
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumArea(int[][] grid) {
            return solution1(grid);
        }

        /**
         * time complexity : O(m*n)
         * space complexity : O(1)
         */
        private int solution1(int[][] grid) {
            int lengthOfArea = lengthOfArea(grid);
            if (lengthOfArea == 0)
                return 0;

            int breadthOfArea = breadthOfArea(grid);

            return lengthOfArea * breadthOfArea;
        }

        private static int lengthOfArea(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            int left = 0, right = cols - 1;
            boolean left_found = false, right_found = false;
            while ((!left_found || !right_found) && left < right) {
                if (!left_found) {
                    for (int i = 0; i < rows; i++) {
                        if (grid[i][left] == 1) {
                            left_found = true;
                            break;
                        }
                    }
                    if (!left_found)
                        left++;
                }
                if (!right_found) {
                    for (int i = 0; i < rows; i++) {
                        if (grid[i][right] == 1) {
                            right_found = true;
                            break;
                        }
                    }
                    if (!right_found)
                        right--;
                }
            }

            return right + 1 - left;
        }

        private static int breadthOfArea(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            int top = 0, bottom = rows - 1;
            boolean top_found = false, bottom_found = false;
            while ((!top_found || !bottom_found) && top < bottom) {
                if (!top_found) {
                    for (int i = 0; i < cols; i++) {
                        if (grid[top][i] == 1) {
                            top_found = true;
                            break;
                        }
                    }
                    if (!top_found)
                        top++;
                }
                if (!bottom_found) {
                    for (int i = 0; i < cols; i++) {
                        if (grid[bottom][i] == 1) {
                            bottom_found = true;
                            break;
                        }
                    }
                    if (!bottom_found)
                        bottom--;
                }
            }

            return bottom + 1 - top;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}