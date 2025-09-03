package leetcode.editor.en;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem : 34
 * Title : Find First and Last Position of Element in Sorted Array
 */
class Driver_34 {
    public static void main(String[] args) {
        int[] result = new Driver_34().new Solution().searchRange(
                new int[]{3, 7, 7, 7, 8},
                7
        );
        System.out.println(
                IntStream.of(result)
                        .boxed()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]"))
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                boolean isLeftEqualsTarget = nums[left] == target;
                boolean isRightEqualsTarget = nums[right] == target;
                if (isLeftEqualsTarget && isRightEqualsTarget) {
                    return new int[]{left, right};
                } else if (isLeftEqualsTarget) {
                    right = findRightBound(nums, left, right, target);
                    return new int[]{left, right};
                } else if (isRightEqualsTarget) {
                    left = findLeftBound(nums, left, right, target);
                    return new int[]{left, right};
                }

                int mid = (left + right) >> 1;

                if (target < nums[mid]) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    left = findLeftBound(nums, left, mid, target);
                    right = findRightBound(nums, mid, right, target);

                    return new int[]{left, right};
                }
            }

            return new int[]{-1, -1};
        }

        /**
         * 1. nums[start] may or may not be equal to target
         * 2. nums[end] must be equal to target, guaranteed by caller
         */
        private int findLeftBound(int[] nums, int start, int end, int target) {
            if (nums[start] == target) {
                return start;
            }

            while (start < end) {
                if (nums[start] == target) {
                    return start;
                } else if (start == end - 1) {
                    return end;
                }

                int mid = (start + end) >> 1;
                if (nums[mid] != target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            return end;
        }

        /**
         * 1. nums[end] may or may not be equal to target
         * 2. nums[start] must be equal to target, guaranteed by caller
         */
        private int findRightBound(int[] nums, int start, int end, int target) {
            if (nums[end] == target) {
                return end;
            }

            while (start < end) {
                if (nums[end] == target) {
                    return end;
                } else if (start == end - 1) {
                    return start;
                }

                int mid = (start + end) >> 1;
                if (nums[mid] != target) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }

            return start;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}