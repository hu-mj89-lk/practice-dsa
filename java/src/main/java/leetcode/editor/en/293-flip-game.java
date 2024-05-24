package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : 293
 * Title : Flip Game
 */
class Driver_293 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generatePossibleNextMoves(String currentState) {
            if (currentState.length() <= 1)
                return List.of();

            List<String> result = new ArrayList<>();

            char[] chars = currentState.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                char curr = chars[i];
                char next = chars[i + 1];

                if (curr == next && curr == '+') {
                    // set
                    chars[i] = '-';
                    chars[i + 1] = '-';

                    result.add(String.copyValueOf(chars));

                    // unset
                    chars[i] = '+';
                    chars[i + 1] = '+';
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
