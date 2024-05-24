package leetcode.editor.en;

/**
 * Problem : 1089
 * Title : Duplicate Zeros
 */
class Driver_1089 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == 0) {
                    shiftRight(arr, i + 1);
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }

        private void shiftRight(int[] arr, int start) {
            int previous = arr[start];
            for (int i = start + 1; i < arr.length; i++) {
                int temp = arr[i];
                arr[i] = previous;
                previous = temp;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
