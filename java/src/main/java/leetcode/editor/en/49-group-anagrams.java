package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem : 49
 * Title : Group Anagrams
 */
class Driver_49 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> anagramGroups = new HashMap<>();

            for (String word : strs) {
                String key = sort(word);
                List<String> words;
                if (!anagramGroups.containsKey(key)) {
                    words = new ArrayList<>();
                    anagramGroups.put(key, words);
                } else {
                    words = anagramGroups.get(key);
                }
                words.add(word);
            }

            return new ArrayList<>(anagramGroups.values());
        }

        private String sort(String word) {
            if (word.length() < 2)
                return word;
            char[] chars = word.toCharArray();
            char[] sortedChars = mergeSort(chars, 0, chars.length - 1);

            return new String(sortedChars);
        }

        private char[] mergeSort(char[] chars, int start, int end) {
            if (start == end) {
                return new char[]{chars[start]};
            }

            int mid = (start + end) / 2;
            char[] left = mergeSort(chars, start, mid);
            char[] right = mergeSort(chars, mid + 1, end);

            return merge(left, right);
        }

        private char[] merge(char[] chars1, char[] chars2) {
            char[] result = new char[chars1.length + chars2.length];

            int i = 0, j = 0, k = 0;
            while (k < result.length) {
                int c1 = i < chars1.length ? chars1[i] : -1;
                int c2 = j < chars2.length ? chars2[j] : -1;
                if (c1 < 0) {
                    result[k++] = chars2[j++];
                } else if (c2 < 0) {
                    result[k++] = chars1[i++];
                } else {
                    if (c1 <= c2) {
                        result[k++] = chars1[i++];
                    } else {
                        result[k++] = chars2[j++];
                    }
                }
            }

            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
