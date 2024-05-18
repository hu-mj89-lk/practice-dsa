package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem : 136
 * Title : Single Number
 */
class Driver_136 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                if (!set.add(i)) {
                    set.remove(i);
                }
            }
            return (int) set.toArray()[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
