package leetcode.editor.en;

/**
 * Problem : 75
 * Title : Sort Colors
 */
class Driver_75 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                // find minimum in remaining
                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < nums[min])
                        min = j;
                }

                // swap
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
