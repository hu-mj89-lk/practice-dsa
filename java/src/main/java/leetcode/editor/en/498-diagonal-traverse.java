package leetcode.editor.en;

/**
 * Problem : 498
 * Title : Diagonal Traverse
 */
class Driver_498 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] result = new int[m * n];

            boolean forward = true;
            int i = 0, j = 0;
            int idx = 0;
            while (idx < result.length) {
                if (forward) {
                    result[idx++] = mat[i--][j++];
                    if (j < n) {
                        if (i < 0) {
                            forward = false;
                            i = 0;
                        }
                    } else {
                        forward = false;
                        j = n - 1;
                        i += 2;
                    }
                } else {
                    result[idx++] = mat[i++][j--];
                    if (i < m) {
                        if (j < 0) {
                            forward = true;
                            j = 0;
                        }
                    } else {
                        forward = true;
                        i = m - 1;
                        j += 2;
                    }
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
