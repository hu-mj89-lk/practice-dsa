package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : 54
 * Title : Spiral Matrix
 */
class Driver_54 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            // bounds
            int top = -1, down = matrix.length;
            int left = -1, right = matrix[0].length;
            int direction = 0;
            // pointer
            int row = 0, col = 0;
            int count = 0;
            while (count++ < matrix.length * matrix[0].length) {
                // visit node
                result.add(matrix[row][col]);
                // increment row/col and adjust bounds
                switch (direction) {
                    case 0:// east
                        col++;
                        if (col == right) {
                            top++;
                            col--;
                            row++;
                            direction = 1;
                        }
                        break;
                    case 1:// south
                        row++;
                        if (row == down) {
                            right--;
                            row--;
                            col--;
                            direction = 2;
                        }
                        break;
                    case 2:// west
                        col--;
                        if (col == left) {
                            down--;
                            col++;
                            row--;
                            direction = 3;
                        }
                        break;
                    case 3:// north
                        row--;
                        if (row == top) {
                            left++;
                            row++;
                            col++;
                            direction = 0;
                        }
                        break;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
