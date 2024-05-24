package leetcode.editor.en;

/**
 * Problem : 487
 * Title : Max Consecutive Ones II
 */
class Driver_487 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0;

            int leftOnes = countOnes(nums, 0);
            int idx = leftOnes + 1;

            if (idx < nums.length) {
                while (idx < nums.length) {
                    int rightOnes = countOnes(nums, idx);

                    int totalOnes = leftOnes + 1 + rightOnes;
                    result = Math.max(result, totalOnes);

                    leftOnes = rightOnes;
                    idx += rightOnes + 1;
                }
            } else {
                result = nums.length;
            }

            return result;
        }

        private int countOnes(int[] arr, int start) {
            int k = 0;
            while (start < arr.length) {
                if (arr[start++] == 1)
                    k++;
                else {
                    return k;
                }
            }

            return k;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
