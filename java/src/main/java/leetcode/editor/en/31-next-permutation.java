package leetcode.editor.en;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Problem : 31
 * Title : Next Permutation
 */
class Driver_31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 8, 5, 7, 9, 6};// ans: 1,4,2,8,5,9,6,7
        new Driver_31().new Solution().nextPermutation(nums);
        System.out.println(
                Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length < 2)
                return;

            for (int i = nums.length - 1; i > 0; i--) {
                int curr = nums[i];
                int prev = nums[i - 1];

                // find anomaly i.e. prev is less than curr
                if (prev >= curr) {
                    continue;
                }

                // find candidate to swap with prev
                int candidate = Integer.MAX_VALUE, candidateIdx = Integer.MAX_VALUE;
                for (int j = i; j < nums.length; j++) {
                    if (prev < nums[j] && nums[j] < candidate) {
                        candidate = nums[j];
                        candidateIdx = j;
                    }
                }

                // swap if candidate exists
                if (candidateIdx != Integer.MAX_VALUE) {
                    nums[i - 1] = candidate;
                    nums[candidateIdx] = prev;

                    // sort in ascending order elements [i,] in-place
                    Arrays.sort(nums, i, nums.length);
                } else {
                    // sort in descending order elements [i,] in-place
                    Arrays.sort(nums, i, nums.length);
                    for (int l = i, r = nums.length - 1; l < r; l++, r--) {
                        int temp = nums[l];
                        nums[l] = nums[r];
                        nums[r] = temp;
                    }
                }
                return;
            }

            // edge case : when given array is sorted in descending order
            Arrays.sort(nums);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}