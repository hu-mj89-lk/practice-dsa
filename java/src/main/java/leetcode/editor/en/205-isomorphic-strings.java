package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 205
 * Title : Isomorphic Strings
 */
class Driver_205 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            return isIsomorphic(sChars, tChars) && isIsomorphic(tChars, sChars);
        }

        private boolean isIsomorphic(char[] chars1, char[] chars2) {
            Map<Character, Character> map = new HashMap<>();

            for (int i = 0; i < chars1.length; i++) {
                if (!map.containsKey(chars1[i])) {
                    map.put(chars1[i], chars2[i]);
                } else if (map.get(chars1[i]) != chars2[i]) {
                    return false;
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
