package leetcode.editor.en;

import java.util.*;

/**
 * Problem : 15
 * Title : 3Sum
 */
class Driver_15 {
    public static void main(String[] args) {
        new Driver_15().new Solution().threeSum(new int[]{0, 0, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // return solution1(nums);
            return solution2(nums);
        }

        /**
         * approach :
         * 1. sort and then iterate over array
         * 2. for each element apply two-sum using Hash Set solution
         * <p>
         * time complexity : O(n^2)
         * space complexity : O(n)
         */
        private List<List<Integer>> solution2(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            // time complexity : O(nlog(n)) , space complexity : O(1) to O(n)
            Arrays.sort(nums);

            int prevOuter = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
                if (nums[i] == prevOuter) {
                    continue;
                }
                prevOuter = nums[i];

                Set<Integer> seen = new HashSet<>();
                int prevInner = Integer.MIN_VALUE;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == prevInner) {
                        continue;
                    }

                    int compliment = -nums[i] - nums[j];
                    if (!seen.contains(compliment)) {
                        seen.add(nums[j]);
                    } else {
                        result.add(List.of(nums[i], compliment, nums[j]));
                        prevInner = nums[j];
                    }
                }
            }

            return result;
        }

        /**
         * approach :
         * 1. sort and then iterate over array
         * 2. for each element apply two-sum w/ sorted array solution
         * <p>
         * time complexity : O(n^2)
         * space complexity : O(1) to O(n) {depends on algorithm used for sorting}
         */
        private List<List<Integer>> solution1(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            // time complexity : O(nlog(n)) , space complexity : O(1) to O(n)
            Arrays.sort(nums);

            int prevOuter = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
                // for unique current element
                if (nums[i] == prevOuter) {
                    continue;
                }
                prevOuter = nums[i];

                // two sum : two-pointer approach
                int left = i + 1, right = nums.length - 1;
                int prevInner = Integer.MIN_VALUE;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        prevInner = nums[left];

                        result.add(List.of(nums[i], nums[left++], nums[right--]));

                        // for unique left element
                        while (left < right && nums[left] == prevInner) {
                            left++;
                        }
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
