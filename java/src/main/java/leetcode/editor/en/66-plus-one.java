package leetcode.editor.en;

/**
 * Problem : 66
 * Title : Plus One
 */
class Driver_66 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int[] result = digits;
            int carry = 1;
            for (int i = result.length - 1; i >= 0; i--) {
                int d = digits[i];

                if (d == 9) {
                    result[i] = 0;
                    carry = 1;
                } else {
                    result[i] = d + carry;
                    carry = 0;
                }

                if (carry == 0)
                    break;
            }

            return carry == 0 ? digits : grow(digits);
        }

        private int[] grow(int[] digits) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, result.length - 1);

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
