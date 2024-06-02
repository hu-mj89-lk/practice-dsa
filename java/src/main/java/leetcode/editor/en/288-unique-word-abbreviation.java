package leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem : 288
 * Title : Unique Word Abbreviation
 */
class Driver_288 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ValidWordAbbr {
        private final Map<String, Set<String>> data;

        public ValidWordAbbr(String[] dictionary) {
            this.data = new HashMap<>();
            for (String word : dictionary) {
                String abb = abbreviation(word);
                Set<String> words = data.getOrDefault(abb, new HashSet<>());
                words.add(word);
                if (words.size() == 1) {
                    data.put(abb, words);
                }
            }
        }

        public boolean isUnique(String word) {
            String abb = abbreviation(word);
            Set<String> words = data.getOrDefault(abb, null);

            return words == null || (words.size() == 1 && words.contains(word));
        }

        private String abbreviation(String word) {
            if (word.length() < 3) {
                return word;
            }
            return String.format("%s%d%s", word.charAt(0), word.length() - 2, word.charAt(word.length() - 1));
        }
    }
    /**
     * Your ValidWordAbbr object will be instantiated and called as such:
     * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
     * boolean param_1 = obj.isUnique(word);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
