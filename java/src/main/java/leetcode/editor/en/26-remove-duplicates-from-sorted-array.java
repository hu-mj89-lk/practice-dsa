package leetcode.editor.en;

/**
 * Problem : 26
 * Title : Remove Duplicates from Sorted Array
 */
class Driver_26 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0;
            int idx = 0;
            while (idx < nums.length) {
                if (nums[idx] != nums[k]) {
                    nums[++k] = nums[idx];
                }
                idx++;
            }

            return k + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
