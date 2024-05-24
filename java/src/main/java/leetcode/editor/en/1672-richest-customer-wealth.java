package leetcode.editor.en;

/**
 * Problem : 1672
 * Title : Richest Customer Wealth
 */
class Driver_1672 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int result = 0;

            for (int i = 0; i < accounts.length; i++) {
                int wealth = 0;
                for (int j = 0; j < accounts[i].length; j++) {
                    wealth += accounts[i][j];
                }
                result = Math.max(result, wealth);
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
