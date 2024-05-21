package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem : 36
 * Title : Valid Sudoku
 */
class Driver_36 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set<Character> set = new HashSet<>(9);

            // horizontal
            for (int r = 0; r < 9; r++) {
                set.clear();
                for (int c = 0; c < 9; c++) {
                    if (board[r][c] != '.' && !set.add(board[r][c]))
                        return false;
                }
            }

            // vertical
            for (int c = 0; c < 9; c++) {
                set.clear();
                for (int r = 0; r < 9; r++) {
                    if (board[r][c] != '.' && !set.add(board[r][c]))
                        return false;
                }
            }

            // block
            for (int r = 0; r < 9; r += 3) {
                for (int c = 0; c < 9; c += 3) {
                    set.clear();
                    for (int row = r; row < r + 3; row++) {
                        for (int col = c; col < c + 3; col++) {
                            if (board[row][col] != '.' && !set.add(board[row][col]))
                                return false;
                        }
                    }
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
