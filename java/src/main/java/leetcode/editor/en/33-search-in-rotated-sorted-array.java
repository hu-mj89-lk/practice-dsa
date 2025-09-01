package leetcode.editor.en;

/**
 * Problem : 33
 * Title : Search in Rotated Sorted Array
 */
class Driver_33 {
    public static void main(String[] args) {
        int result = new Driver_33().new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return solution1(nums, target);
        }

        private int solution1(int[] nums, int target) {
            boolean isLeftRotated = nums[0] > nums[nums.length - 1];
            if (!isLeftRotated) {
                return binarySearch(nums, 0, nums.length - 1, target);
            }

            // find pivot (largest element in the array)
            int pivot = -1;
            {
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                    int mid = (left + right) >> 1;

                    if (nums[mid] > nums[mid + 1]) {
                        pivot = mid;
                        break;
                    } else if (nums[mid] >= nums[nums.length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[0] <= target && target < nums[pivot]) {
                return binarySearch(nums, 0, pivot - 1, target);
            } else {
                return binarySearch(nums, pivot + 1, nums.length - 1, target);
            }
        }

        private int binarySearch(int[] nums, int start, int end, int target) {
            int result = -1;

            while (start >= 0 && end < nums.length && start <= end) {
                int mid = (start + end) >> 1;
                if (nums[mid] == target) {
                    result = mid;
                    break;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}