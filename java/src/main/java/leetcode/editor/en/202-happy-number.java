package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem : 202
 * Title : Happy Number
 */
class Driver_202 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> nums = new HashSet<>();
            while ((n = sumSquaresOfDigits(n)) != 1) {
                if (!nums.add(n))
                    return false;
            }

            return true;
        }

        private int sumSquaresOfDigits(int number) {
            int result = 0;

            while (number > 0) {
                int digit = number % 10;
                result += digit * digit;
                number /= 10;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
