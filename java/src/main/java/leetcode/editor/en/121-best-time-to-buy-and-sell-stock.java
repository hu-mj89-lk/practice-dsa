package leetcode.editor.en;

/**
 * Problem : 121
 * Title : Best Time to Buy and Sell Stock
 */
class Driver_121 {
    public static void main(String[] args) {
        int result = new Driver_121().new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            return solution1(prices);
        }

        /**
         * sliding window
         * <p>
         * time complexity : O(n)
         * space complexity : O(1)
         */
        private int solution1(int[] prices) {
            if (prices.length <= 1)
                return 0;

            int maxProfit = 0;
            for (int left = 0, right = 1; right < prices.length; right++) {
                if (prices[left] < prices[right]) {
                    int profit = prices[right] - prices[left];
                    maxProfit = Math.max(maxProfit, profit);
                } else if (prices[left] > prices[right]) {
                    left = right;
                }
            }

            return maxProfit;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}