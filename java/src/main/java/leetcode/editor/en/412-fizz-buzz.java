package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : 412
 * Title : Fizz Buzz
 */
class Driver_412 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if ((i % 3 == 0) && (i % 5 == 0))
                    result.add("FizzBuzz");
                else if (i % 3 == 0)
                    result.add("Fizz");
                else if (i % 5 == 0)
                    result.add("Buzz");
                else
                    result.add(i + "");
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
