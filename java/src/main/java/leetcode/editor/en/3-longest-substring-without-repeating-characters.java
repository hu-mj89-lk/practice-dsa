package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 3
 * Title : Longest Substring Without Repeating Characters
 */
class Driver_3 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            return solutionMy(s);
        }

        /**
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private int solutionMy(String s) {
            int result = 0;

            char[] chars = s.toCharArray();

            Map<Character, Integer> lastSeenIndex = new HashMap<>();
            int l = 0, r = 0;// slidingWindow
            while (r < chars.length) {
                Integer lastIdx;
                if ((lastIdx = lastSeenIndex.put(chars[r], r)) == null || lastIdx < l) {
                    r++;
                    continue;
                }

                result = Math.max(result, r - l);

                l = lastIdx + 1;
                r++;
            }

            return Math.max(result, r - l);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
