package leetcode.editor.en;

/**
 * Problem : 67
 * Title : Add Binary
 */
class Driver_67 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            char[] result = new char[Math.max(a.length(), b.length())];

            int carry = 0;
            for (int i = a.length() - 1, j = b.length() - 1, k = result.length - 1; i >= 0 || j >= 0; i--, j--, k--) {
                int x = i > -1 ? a.charAt(i) - '0' : 0;
                int y = j > -1 ? b.charAt(j) - '0' : 0;
                int sum = x + y + carry;

                switch (sum) {
                    case 3:
                        result[k] = '1';
                        carry = 1;
                        break;
                    case 2:
                        result[k] = '0';
                        carry = 1;
                        break;
                    case 1:
                        result[k] = '1';
                        carry = 0;
                        break;
                    case 0:
                        result[k] = '0';
                        carry = 0;
                        break;
                }
            }

            if (carry > 0) {
                return "1" + new String(result);
            }
            return new String(result);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
