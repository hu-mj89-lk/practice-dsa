package leetcode.editor.en;

import java.util.*;

/**
 * Problem : 286
 * Title : Walls and Gates
 */
class Driver_286 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wallsAndGates(int[][] rooms) {
            // new SolutionMy().wallsAndGates(rooms);
            new Solution1().wallsAndGates(rooms);
        }

        private static class Solution1 {
            private static final int EMPTY = Integer.MAX_VALUE;
            private static final int GATE = 0;
            private static final List<int[]> DIRECTIONS = Arrays.asList(
                    new int[]{1, 0},
                    new int[]{-1, 0},
                    new int[]{0, 1},
                    new int[]{0, -1}
            );

            private void wallsAndGates(int[][] rooms) {
                int m = rooms.length;
                if (m == 0) return;
                int n = rooms[0].length;
                Queue<int[]> q = new LinkedList<>();
                for (int row = 0; row < m; row++) {
                    for (int col = 0; col < n; col++) {
                        if (rooms[row][col] == GATE) {
                            q.add(new int[]{row, col});
                        }
                    }
                }
                while (!q.isEmpty()) {
                    int[] point = q.poll();
                    int row = point[0];
                    int col = point[1];
                    for (int[] direction : DIRECTIONS) {
                        int r = row + direction[0];
                        int c = col + direction[1];
                        if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                            continue;
                        }
                        rooms[r][c] = rooms[row][col] + 1;
                        q.add(new int[]{r, c});
                    }
                }
            }
        }

        private static class SolutionMy {
            private void wallsAndGates(int[][] rooms) {
                for (int row = 0; row < rooms.length; row++) {
                    for (int col = 0; col < rooms[row].length; col++) {
                        int val = rooms[row][col];
                        if (val != 0) {
                            continue;
                        }

                        Set<Coordinate> visited = new HashSet<>();
                        Queue<Coordinate> queue = new LinkedList<>();
                        queue.offer(new Coordinate(row, col));

                        while (!queue.isEmpty()) {
                            Coordinate curr = queue.poll();
                            if (!visited.add(curr)) {
                                continue;
                            }

                            int r = curr.row, c = curr.col;
                            int currVal = rooms[r][c];
                            List<Coordinate> neighbours = neighbours(r, c, rooms);

                            for (Coordinate neighbour : neighbours) {
                                rooms[neighbour.row][neighbour.col] =
                                        Math.min(rooms[neighbour.row][neighbour.col], currVal + 1);
                                queue.offer(neighbour);
                            }
                        }
                    }
                }
            }

            private List<Coordinate> neighbours(int r, int c, int[][] rooms) {
                int m = rooms.length, n = rooms[0].length;
                List<Coordinate> result = new ArrayList<>(List.of(
                        new Coordinate(r - 1, c),
                        new Coordinate(r + 1, c),
                        new Coordinate(r, c - 1),
                        new Coordinate(r, c + 1)
                ));
                Iterator<Coordinate> iterator = result.iterator();
                while (iterator.hasNext()) {
                    Coordinate next = iterator.next();
                    int row = next.row, col = next.col;
                    if ((row < 0 || row >= m) ||
                            (col < 0 || col >= n) ||
                            rooms[row][col] <= 0) {
                        iterator.remove();
                    }
                }

                return result;
            }

            private static class Coordinate {
                private final int row;
                private final int col;

                Coordinate(int row, int col) {
                    this.row = row;
                    this.col = col;
                }

                @Override
                public boolean equals(Object object) {
                    if (this == object) return true;
                    if (object == null || getClass() != object.getClass()) return false;
                    Coordinate that = (Coordinate) object;
                    return row == that.row && col == that.col;
                }

                @Override
                public int hashCode() {
                    return Objects.hash(row, col);
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
