package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem : 1424
 * Title : Diagonal Traverse II
 */
class Driver_1424 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            List<Integer> answer = new LinkedList<>();

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] coordinates = queue.poll();
                int row = coordinates[0];
                int col = coordinates[1];

                // process current
                answer.add(nums.get(row).get(col));

                if (col == 0 && row + 1 < nums.size()) {
                    queue.offer(new int[]{row + 1, col});
                }
                if (col + 1 < nums.get(row).size()) {
                    queue.offer(new int[]{row, col + 1});
                }
            }

            int[] result = new int[answer.size()];
            int i = 0;
            for (Integer num : answer) {
                result[i++] = num;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
