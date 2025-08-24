package leetcode.editor.en;

/**
 * Problem : 3477
 * Title : Fruits Into Baskets II
 */
class Driver_3477 {
    public static void main(String[] args) {
        int result = new Driver_3477().new Solution().numOfUnplacedFruits(
                new int[]{3, 6, 1},
                new int[]{6, 4, 7}
        );
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            return solutionBF(fruits, baskets);
        }

        /**
         * approach : brute force
         * <p>
         * time complexity : O(n^2)
         * space complexity : O(1)
         */
        private int solutionBF(int[] fruits, int[] baskets) {
            for (int i = 0; i < fruits.length; i++) {
                int quantityOfCurrentFruit = fruits[i];
                for (int j = 0; j < baskets.length; j++) {
                    int basket = baskets[j];
                    if (basket == Integer.MIN_VALUE || basket < quantityOfCurrentFruit)
                        continue;

                    baskets[j] = Integer.MIN_VALUE;
                    fruits[i] = Integer.MIN_VALUE;
                    break;
                }
            }

            int result = 0;
            for (int i = 0; i < fruits.length; i++) {
                if (fruits[i] != Integer.MIN_VALUE) {
                    result++;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}