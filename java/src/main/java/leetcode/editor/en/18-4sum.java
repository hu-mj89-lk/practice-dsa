package leetcode.editor.en;

import java.util.*;

/**
 * Problem : 18
 * Title : 4Sum
 */
class Driver_18 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Driver_18().new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            //return new SolutionBF().fourSum(nums, target);
            //return new Solution1().fourSum(nums, target);
            return new Solution2().fourSum(nums, target);
        }

        /**
         * 1. Sort array using in-place, logarithmic algorithm
         * 2. Generate combinations of 2 distinct numbers
         * 3. For each combination, find the other 2 numbers by applying 2-sum for new target = target - (nums[i] + nums[j])
         * <p>
         * time complexity : O(n^3)
         * space complexity : O(1)
         */
        private static class Solution2 {

            public List<List<Integer>> fourSum(int[] nums, int target) {
                if (nums.length < 4)
                    return List.of();

                // time complexity : O(nLog(n)), space complexity : O(1)
                Arrays.sort(nums);

                Set<Quadruplet> uniqueQuadruplets = new HashSet<>();
                for (int a = 0; a < nums.length; a++) {
                    // skip duplicates
                    if (a > 0 && nums[a] == nums[a - 1]) {
                        continue;
                    }

                    final int num1 = nums[a];

                    for (int b = a + 1; b < nums.length; b++) {
                        // skip duplicates
                        if (b > (a + 1) && nums[b] == nums[b - 1]) {
                            continue;
                        }

                        final int num2 = nums[b];
                        long currentTarget = Long.sum(target, -(num1 + num2));

                        List<Integer[]> twoSumSolutions = twoSumInSubArray(nums, b + 1, currentTarget);
                        if (twoSumSolutions == null)
                            continue;

                        twoSumSolutions.stream()
                                .map(e -> new Quadruplet(num1, num2, e[0], e[1]))
                                .forEach(uniqueQuadruplets::add);
                    }
                }

                List<List<Integer>> result = new ArrayList<>();
                for (Quadruplet quadruplet : uniqueQuadruplets) {
                    result.add(quadruplet.getData());
                }

                return result;
            }

            private List<Integer[]> twoSumInSubArray(int[] nums, int start, long target) {
                if (start >= nums.length - 1)
                    return null;

                List<Integer[]> result = new ArrayList<>();

                int left = start, right = nums.length - 1;
                while (left < right) {
                    long sum = nums[left] + nums[right];
                    if (sum == target) {
                        result.add(new Integer[]{nums[left], nums[right]});
                        left++;
                        right--;

                        // skip duplicates
                        {
                            while (left < right && nums[left] == nums[left - 1])
                                left++;
                            while (left < right && nums[right] == nums[right + 1])
                                right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

                return result;
            }
        }

        /**
         * 1. Sort array using in-place, logarithmic algorithm
         * 2. Generate combinations of 2 distinct numbers
         * 3. For each combination, find the other 2 numbers by applying 2-sum for new target = target - (nums[i] + nums[j])
         * <p>
         * time complexity : O(n^3)
         * space complexity : O(n)
         */
        private static class Solution1 {

            public List<List<Integer>> fourSum(int[] nums, int target) {
                if (nums.length < 4)
                    return List.of();

                // time complexity : O(nLog(n)), space complexity : O(1)
                Arrays.sort(nums);

                Set<Quadruplet> uniqueQuadruplets = new HashSet<>();
                for (int a = 0; a < nums.length; a++) {
                    final int num1 = nums[a];

                    for (int b = a + 1; b < nums.length; b++) {
                        final int num2 = nums[b];
                        long currentTarget = Long.sum(target, -(num1 + num2));

                        List<Integer[]> twoSumSolutions = twoSumInSubArray(nums, b + 1, currentTarget);
                        if (twoSumSolutions == null)
                            continue;

                        twoSumSolutions.stream()
                                .map(e -> new Quadruplet(num1, num2, e[0], e[1]))
                                .forEach(uniqueQuadruplets::add);
                    }
                }

                List<List<Integer>> result = new ArrayList<>();
                for (Quadruplet quadruplet : uniqueQuadruplets) {
                    result.add(quadruplet.getData());
                }

                return result;
            }

            private List<Integer[]> twoSumInSubArray(int[] nums, int start, long target) {
                if (start >= nums.length - 1)
                    return null;

                List<Integer[]> result = new ArrayList<>();

                // compliment to index(es) map
                Map<Long, List<Integer>> complimentMap = new HashMap<>();
                for (int i = start; i < nums.length; i++) {
                    long curr = nums[i];
                    long compliment = target - curr;

                    if (complimentMap.containsKey(compliment)) {
                        result.add(new Integer[]{Math.toIntExact(curr), Math.toIntExact(compliment)});
                        List<Integer> indexes = complimentMap.get(compliment);
                        indexes.remove(0);
                        if (indexes.isEmpty()) {
                            complimentMap.remove(compliment);
                        }
                    } else {
                        if (complimentMap.containsKey(curr)) {
                            complimentMap.get(curr).add(i);
                        } else {
                            List<Integer> indexes = new ArrayList<>();
                            indexes.add(i);
                            complimentMap.put(curr, indexes);
                        }
                    }
                }

                return result;
            }
        }

        /**
         * approach : brute force
         * <p>
         * time complexity : O(n^4)
         * space complexity : O(n)
         */
        private static class SolutionBF {
            private List<List<Integer>> fourSum(int[] nums, int target) {
                if (nums.length < 4)
                    return List.of();

                Set<Quadruplet> uniqueQuadruplets = new HashSet<>();
                for (int i = 0; i < nums.length; i++) {
                    for (int j = 0; j < nums.length; j++) {
                        if (j == i) {
                            continue;
                        }
                        for (int k = 0; k < nums.length; k++) {
                            if (k == j || k == i) {
                                continue;
                            }
                            for (int l = 0; l < nums.length; l++) {
                                if (l == k || l == j || l == i) {
                                    continue;
                                }
                                long sum = Long.sum(nums[i], nums[j]) + Long.sum(nums[k], nums[l]);

                                if (sum == target) {
                                    uniqueQuadruplets.add(new Quadruplet(nums[i], nums[j], nums[k], nums[l]));
                                }
                            }
                        }
                    }
                }

                List<List<Integer>> result = new ArrayList<>();
                for (Quadruplet quadruplet : uniqueQuadruplets) {
                    result.add(quadruplet.getData());
                }

                return result;
            }
        }

        private static class Quadruplet {
            private final int[] data;

            private Quadruplet(int num1, int num2, int num3, int num4) {
                this.data = new int[]{num1, num2, num3, num4};
                Arrays.sort(this.data);
            }

            private List<Integer> getData() {
                return List.of(data[0], data[1], data[2], data[3]);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(data);
            }

            @Override
            public boolean equals(Object object) {
                if (this == object) return true;
                if (object == null || getClass() != object.getClass()) return false;
                Quadruplet quadruplet = (Quadruplet) object;
                return Objects.deepEquals(data, quadruplet.data);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
