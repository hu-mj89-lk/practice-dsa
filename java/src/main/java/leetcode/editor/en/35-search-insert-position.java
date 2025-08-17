package leetcode.editor.en;

/**
 * Problem : 35
 * Title : Search Insert Position
 */
class Driver_35 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int mid = -1;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}