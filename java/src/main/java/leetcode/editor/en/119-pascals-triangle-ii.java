package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Problem : 119
 * Title : Pascal's Triangle II
 */
class Driver_119 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> prev = new ArrayList<>();
            for (int i = 0; i < rowIndex + 1; i++) {
                List<Integer> curr = new ArrayList<>();

                Iterator<Integer> prevItr = prev.iterator();
                Integer prevN1 = 0;
                while (prevItr.hasNext()) {
                    Integer prevN2 = prevItr.next();
                    curr.add(prevN1 + prevN2);
                    prevN1 = prevN2;
                }
                curr.add(1);
                prev = curr;
            }

            return prev;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
