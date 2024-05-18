package leetcode.editor.en;

/**
 * Problem : 387
 * Title : First Unique Character in a String
 */
class Driver_387 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            char[] sChars = s.toCharArray();

            int[] frequencyTable = new int[26];
            for (int i = 0; i < sChars.length; i++) {
                frequencyTable[sChars[i] - 'a'] += 1;
            }

            for (int i = 0; i < sChars.length; i++) {
                if (frequencyTable[sChars[i] - 'a'] == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
