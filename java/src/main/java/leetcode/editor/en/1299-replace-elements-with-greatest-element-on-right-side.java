package leetcode.editor.en;

/**
 * Problem : 1299
 * Title : Replace Elements with Greatest Element on Right Side
 */
class Driver_1299 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] replaceElements(int[] arr) {
            // arr.length = 1
            if (arr == null)
                return arr;
            else if (arr.length == 1) {
                arr[0] = -1;
                return arr;
            }

            int greatest = -1;
            for (int i = arr.length - 2; i >= 0; i--) {
                int temp = arr[i];
                arr[i] = Math.max(arr[i + 1], greatest);
                greatest = Math.max(temp, greatest);
            }

            arr[arr.length - 1] = -1;

            return arr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
