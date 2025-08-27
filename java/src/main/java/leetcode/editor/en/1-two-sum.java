package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Problem : 1
 * Title : Two Sum
 */
class Driver_1 {
    public static void main(String[] args) {
        int[] result = new Driver_1().new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(
                Arrays.stream(result)
                        .boxed()
                        .collect(Collectors.toSet())
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // return solutionBF(nums, target);
            return solution1(nums, target);
        }

        /**
         * iterate over elements, try finding their compliment in already visited elements
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private int[] solution1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int other;
                if (map.containsKey((other = target - nums[i])))
                    return new int[]{i, map.get(other)};
                else
                    map.put(nums[i], i);
            }
            return null;
        }

        /**
         * Brute force approach to test all combinations
         * <p>
         * time complexity : O(n^2)
         * space complexity : O(1)
         */
        private int[] solutionBF(int[] nums, int target) {
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                result[0] = i;
                for (int j = 0; j < nums.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    result[1] = j;
                    if (nums[i] + nums[j] == target) {
                        return result;
                    }
                }
            }

            return null;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
