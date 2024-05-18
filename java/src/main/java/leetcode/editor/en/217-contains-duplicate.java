package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem : 217
 * Title : Contains Duplicate
 */
class Driver_217 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                if (!set.add(i)) {// first duplicate found
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
