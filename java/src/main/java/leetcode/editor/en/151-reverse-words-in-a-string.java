package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : 151
 * Title : Reverse Words in a String
 */
class Driver_151 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {

            List<String> words = new ArrayList<>();

            StringBuilder wordBuilder = new StringBuilder();
            char[] chars = s.toCharArray();
            boolean inWord = false;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    if (inWord) {
                        // cut word
                        words.add(wordBuilder.toString());

                        wordBuilder = new StringBuilder();
                        inWord = false;
                    }
                } else {
                    inWord = true;
                    wordBuilder.append(chars[i]);
                }
            }

            if (!wordBuilder.isEmpty()) {
                words.add(wordBuilder.toString());
            }

            StringBuilder strBuilder = new StringBuilder();
            for (int i = words.size() - 1; i >= 0; i--) {
                strBuilder.append(words.get(i));
                if (i > 0)
                    strBuilder.append(' ');
            }

            return strBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
