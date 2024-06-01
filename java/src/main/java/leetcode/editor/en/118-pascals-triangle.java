package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Problem : 118
 * Title : Pascal's Triangle
 */
class Driver_118 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> prev = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                List<Integer> curr = new ArrayList<>();
                Iterator<Integer> prevItr = prev.iterator();
                Integer prevN1 = 0;
                while (prevItr.hasNext()) {
                    Integer prevN2 = prevItr.next();
                    curr.add(prevN1 + prevN2);
                    prevN1 = prevN2;
                }
                curr.add(1);

                result.add((prev = curr));
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
