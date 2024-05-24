package leetcode.editor.en;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Problem : 1057
 * Title : Campus Bikes
 */
class Driver_1057 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            // worker, bike, distance
            int[][] pairs = new int[workers.length * bikes.length][];

            // create all worker-bike pairs
            for (int i = 0, counter = 0; i < workers.length; i++) {
                int wx = workers[i][0];
                int wy = workers[i][1];

                for (int j = 0; j < bikes.length; j++) {
                    int bx = bikes[j][0];
                    int by = bikes[j][1];
                    int distance = distance(wx, wy, bx, by);

                    pairs[counter++] = new int[]{i, j, distance};
                }
            }

            // sort pairs
            AtomicInteger arCounter = new AtomicInteger(0);
            Stream.of(pairs)
                    .sorted((p1, p2) -> logic(p1[0], p1[1], p1[2], p2[0], p2[1], p2[2]))
                    .forEach(pair -> pairs[arCounter.getAndIncrement()] = pair);

            // prepare result
            int[] result = new int[workers.length];

            for (int a = 0, counter = 0; a < pairs.length && counter < result.length; a++) {
                int worker = pairs[a][0];
                int bike = pairs[a][1];

                if (workers[worker][0] < 0 || bikes[bike][0] < 0)
                    continue;

                result[worker] = bike;
                // mark consumed
                workers[worker][0] += Integer.MIN_VALUE;
                bikes[bike][0] += Integer.MIN_VALUE;

                counter++;
            }

            return result;
        }

        private int logic(int w1, int b1, int d1, int w2, int b2, int d2) {
            if (d1 != d2)
                return d1 - d2;
            else if (w1 != w2)
                return w1 - w2;
            else
                return b1 - b2;
        }

        private int distance(int wx, int wy, int bx, int by) {
            return Math.abs(wx - bx) + Math.abs(wy - by);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
