package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem : 249
 * Title : Group Shifted Strings
 */
class Driver_249 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> map = new HashMap<>();

            for (String word : strings) {
                String signature = signature(word);
                if (!map.containsKey(signature))
                    map.put(signature, new ArrayList<>());

                map.get(signature).add(word);
            }

            return new ArrayList<>(map.values());
        }

        private String signature(String word) {
            StringBuilder signature = new StringBuilder();
            char[] chars = word.toCharArray();

            int diff = chars[0] - 'a';
            for (char c : chars) {
                int v = c - diff >= 'a' ? c - diff : (c - diff + 26);
                signature.append((char) v);
            }

            return signature.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
