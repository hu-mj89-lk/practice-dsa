package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem : 200
 * Title : Number of Islands
 */
class Driver_200 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            // return new SolutionMy().numIslands(grid);
            return new Solution1().numIslands(grid);
        }

        /**
         * approach : DFS
         * <p>
         * time complexity : O(m*n)
         * space complexity : O(m*n)
         */
        private static class Solution1 {
            private static final Character VISITED = '2';
            private static final Character LAND = '1';

            private int numIslands(char[][] grid) {
                int result = 0;

                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == LAND) {
                            dfs(grid, i, j);
                            result++;
                        }
                    }
                }

                return result;
            }

            private void dfs(char[][] grid, int row, int col) {
                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != LAND) {
                    return;
                }

                grid[row][col] = VISITED;

                dfs(grid, row - 1, col);
                dfs(grid, row + 1, col);
                dfs(grid, row, col - 1);
                dfs(grid, row, col + 1);
            }
        }

        /**
         * approach : BFS
         * <p>
         * time complexity : O(m*n)
         * space complexity : O(min(m,n))
         */
        private static class SolutionMy {
            private static final Character VISITED = '2';
            private static final Character LAND = '1';
            private static final List<int[]> DIRECTIONS = Arrays.asList(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});

            private int numIslands(char[][] grid) {
                int result = 0;

                int m = grid.length, n = grid[0].length;
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == LAND) {
                            Queue<int[]> queue = new LinkedList<>();
                            queue.offer(new int[]{i, j});

                            // traverse island
                            while (!queue.isEmpty()) {
                                int[] curr = queue.poll();
                                if (grid[curr[0]][curr[1]] != LAND) {
                                    continue;
                                }
                                // mark visited
                                grid[curr[0]][curr[1]] = VISITED;

                                // enqueue neighbours
                                for (int[] direction : DIRECTIONS) {
                                    int r = curr[0] + direction[0];
                                    int c = curr[1] + direction[1];
                                    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != LAND) {
                                        continue;
                                    }
                                    queue.offer(new int[]{r, c});
                                }
                            }

                            result++;
                        }
                    }
                }

                return result;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
