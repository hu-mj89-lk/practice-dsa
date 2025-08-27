package leetcode.editor.en;

import java.util.Arrays;

/**
 * Problem : 16
 * Title : 3Sum Closest
 */
class Driver_16 {
    public static void main(String[] args) {
        int result = new Driver_16().new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            return solution1(nums, target);
        }

        /**
         * 1. Sort using in-place, logarithmic algorithm
         * 2. For each element, freeze it and apply 2-sum w/ two pointer like approach
         * <p>
         * time complexity : O(n^2)
         * space complexity : O(1)
         */
        private int solution1(int[] nums, int target) {
            // time complexity : O(nLog(n)), space complexity : O(1)
            Arrays.sort(nums);

            int result = Integer.MIN_VALUE;
            int resultDeviationFromTarget = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];

                for (int left = i + 1, right = nums.length - 1; left < right; ) {
                    int b = nums[left], c = nums[right];

                    int sum = a + b + c;
                    int deviationFromTarget = Math.abs(target - sum);

                    if (deviationFromTarget <= resultDeviationFromTarget) {
                        result = sum;
                        resultDeviationFromTarget = deviationFromTarget;
                    }

                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return result;
        }

        /**
         * Iterate through all combinations of selecting 3 numbers out of n i.e. nC3
         * time complexity : O(n^3)
         * space complexity : O(1)
         * <p>
         * TLE
         */
        private int solutionBF(int[] nums, int target) {
            int result = Integer.MIN_VALUE;
            int resultDeviationFromTarget = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                for (int j = 0; j < nums.length; j++) {
                    if (j == i)
                        continue;
                    int b = nums[j];
                    for (int k = 0; k < nums.length; k++) {
                        if (k == j || k == i)
                            continue;
                        int c = nums[k];

                        int sum = a + b + c;
                        int deviationFromTarget = Math.abs(target - sum);

                        if (deviationFromTarget < resultDeviationFromTarget) {
                            result = sum;
                            resultDeviationFromTarget = deviationFromTarget;
                        }
                    }
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}