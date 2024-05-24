package leetcode.editor.en;

/**
 * Problem : 557
 * Title : Reverse Words in a String III
 */
class Driver_557 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();

            StringBuilder result = new StringBuilder();
            int start = 0, end = 0;
            while (end < chars.length) {
                if (chars[end] != ' ') {
                    end++;
                    continue;
                }

                for (int k = end - 1; k >= start; k--) {
                    result.append(chars[k]);
                }
                result.append(' ');

                end++;
                start = end;
            }

            for (int k = end - 1; k >= start; k--) {
                result.append(chars[k]);
            }

            return result.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
