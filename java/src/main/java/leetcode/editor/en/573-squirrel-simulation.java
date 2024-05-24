package leetcode.editor.en;

/**
 * Problem : 573
 * Title : Squirrel Simulation
 */
class Driver_573 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int totalDistance = 0;

            int selectedSaving = Integer.MIN_VALUE;
            for (int i = 0; i < nuts.length; i++) {
                int distanceTreeToNut = distance(tree[0], tree[1], nuts[i][0], nuts[i][1]);
                int distanceSquirrelToNut = distance(squirrel[0], squirrel[1], nuts[i][0], nuts[i][1]);

                int saving = distanceTreeToNut - distanceSquirrelToNut;
                if (saving > selectedSaving) {
                    selectedSaving = saving;
                }

                totalDistance += 2 * distanceTreeToNut;
            }

            totalDistance -= selectedSaving;

            return totalDistance;
        }

        private int distance(int sr, int sc, int dr, int dc) {
            return Math.abs(dr - sr) + Math.abs(dc - sc);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
