package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 904
 * Title : Fruit Into Baskets
 */
class Driver_904 {
    public static void main(String[] args) {
        int result = new Driver_904().new Solution().totalFruit(new int[]{0, 1, 2, 2});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            return solution1(fruits);
        }

        /**
         * time complexity : O(n)
         * space complexity : O(1)
         */
        private int solution1(int[] fruits) {
            int result = Integer.MIN_VALUE;

            int left = -1, right = -1;
            int f1 = Integer.MIN_VALUE, f2 = Integer.MIN_VALUE;
            for (int i = 0; i < fruits.length; i++) {
                int curr = fruits[i];
                if (f1 == Integer.MIN_VALUE) {
                    f1 = curr;
                    left++;
                    right++;
                    continue;
                } else if (curr == f1 || curr == f2) {
                    right++;
                    continue;
                } else if (f2 == Integer.MIN_VALUE) {
                    f2 = curr;
                    right++;
                    continue;
                }

                int windowLength = right - left + 1;
                result = Math.max(result, windowLength);
                int prev = fruits[i - 1];

                // move left ptr forward
                for (int k = i - 1; k > -1; k--) {
                    if (prev != fruits[k]) {
                        left = k + 1;
                        break;
                    }
                }

                f1 = curr;
                f2 = prev;

                right++;
            }

            return Math.max(result, right - left + 1);
        }

        /**
         * time complexity : O(n^2)
         * space complexity : O(1)
         */
        private int solutionTLE(int[] fruits) {
            int result = 0;

            for (int i = 0; i < fruits.length; i++) {

                int left = 0;
                Map<Integer, Integer> leftTable = new HashMap<>();
                for (int k = i; k >= 0; k--) {
                    int curr = fruits[k];
                    if (!leftTable.containsKey(curr)) {
                        if (leftTable.size() == 2)
                            break;
                        leftTable.put(curr, 1);
                    }
                    left++;
                }

                int right = 0;
                Map<Integer, Integer> rightTable = new HashMap<>();
                for (int k = i; k < fruits.length; k++) {
                    int curr = fruits[k];
                    if (!rightTable.containsKey(curr)) {
                        if (rightTable.size() == 2)
                            break;
                        rightTable.put(curr, 1);
                    }
                    right++;
                }

                result = Math.max(result, Math.max(left, right));
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}