package leetcode.editor.en;

/**
 * Problem : 14
 * Title : Longest Common Prefix
 */
class Driver_14 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            return solutionMy(strs);
        }

        private String solutionMy(String[] strs) {
            if (strs.length < 2)
                return strs[0];

            for (int i = 0; i < strs[0].length(); i++) {
                char curr = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || curr != strs[j].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }

            return strs[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
