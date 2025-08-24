package leetcode.editor.en;

import java.util.*;

/**
 * Problem : 18
 * Title : 4Sum
 */
class Driver_18 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            return solutionBF(nums, target);
        }

//        public List<List<Integer>> solution1(int[] nums, int target) {
//            List<List<Integer>> result = new ArrayList<>();
//
//            Map<Integer, List<Integer[]>> sumMap = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = 0; j < nums.length; j++) {
//                    if (j == i) {
//                        continue;
//                    }
//                    int sum = nums[i] + nums[j];
//
//                    List<Integer[]> constituents = sumMap.getOrDefault(sum, new ArrayList<>());
//                    if (constituents.size() == 0) {
//                        constituents.add(new Integer[]{nums[i], nums[j]});
//                    } else {
//
//                    }
//
//                    sumMap.put(sum, constituents);
//                }
//            }
//
//            for (Map.Entry<Integer, List<Integer[]>> entry : sumMap.entrySet()) {
//                int sum = entry.getKey();
//                List<Integer[]> sumConstituents = entry.getValue();
//                int compliment = target - sum;
//                if (sumMap.containsKey(compliment)) {
//                    List<Integer[]> complimentConstituents = sumMap.get(compliment);
//                    result.add(List.of(
//                            sumConstituents[0],
//                            sumConstituents[1],
//                            complimentConstituents[0],
//                            complimentConstituents[1]
//                    ));
//                }
//            }
//
//            return result;
//        }

        /**
         * approach : brute force
         * <p>
         * time complexity : O(n^4)
         * space complexity : O(n)
         */
        private List<List<Integer>> solutionBF(int[] nums, int target) {
            class Quadruplet {
                private final int[] data;

                Quadruplet(int num1, int num2, int num3, int num4) {
                    this.data = new int[]{num1, num2, num3, num4};
                    // insertion sort
                    for (int i = 0; i < this.data.length; i++) {
                        for (int j = i + 1; j < this.data.length; j++) {
                            if (this.data[i] > this.data[j]) {
                                int temp = this.data[i];
                                this.data[i] = this.data[j];
                                this.data[j] = temp;
                            }
                        }
                    }
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
                            if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
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
    //leetcode submit region end(Prohibit modification and deletion)

}
