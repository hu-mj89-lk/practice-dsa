package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem : 771
 * Title : Jewels and Stones
 */
class Driver_771 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            int result = 0;

            Set<Character> jewelsSet = new HashSet<>();
            for (char stone : jewels.toCharArray()) {
                jewelsSet.add(stone);
            }

            for (char stone : stones.toCharArray()) {
                if (jewelsSet.contains(stone)) {
                    result++;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
