package leetcode.editor.en;

/**
 * Problem : 1346
 * Title : Check If N and Its Double Exist
 */
class Driver_1346 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            int i = 0;
            while (i < arr.length) {
                for (int j = 0; j < arr.length; j++) {
                    if (i != j && arr[i] == 2 * arr[j])
                        return true;
                }

                i++;
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
