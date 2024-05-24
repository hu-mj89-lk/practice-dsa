package leetcode.editor.en;

/**
 * Problem : 344
 * Title : Reverse String
 */
class Driver_344 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
