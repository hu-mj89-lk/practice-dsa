package leetcode.editor.en;

/**
 * Problem : 28
 * Title : Find the Index of the First Occurrence in a String
 */
class Driver_28 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            char[] haystackChars = haystack.toCharArray();
            char[] needleChars = needle.toCharArray();

            int left = 0;
            while (left < haystackChars.length) {
                if (left + needleChars.length > haystackChars.length)
                    return -1;

                boolean found = true;
                for (int i = 0; i < needleChars.length; i++) {
                    if (haystackChars[left + i] != needleChars[i]) {
                        left++;
                        found = false;
                        break;
                    }
                }

                if (found)
                    return left;
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
