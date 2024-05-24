package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 454
 * Title : 4Sum II
 */
class Driver_454 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            // return solutionBF(nums1, nums2, nums3, nums4);
            return solution1(nums1, nums2, nums3, nums4);
        }

        /**
         * approach :
         * 1. prepare Hash Map of sum to frequency using any 2 arrays.
         * 2. for all combinations created using remaining two arrays, search compliment in Hash Map
         * <p>
         * time complexity : O(n^2)
         * space complexity : O(n^2)
         */
        private int solution1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int result = 0;

            Map<Integer, Integer> sumToFrequencyMap = new HashMap<>();

            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int sum = nums1[i] + nums2[j];
                    sumToFrequencyMap.put(sum, sumToFrequencyMap.getOrDefault(sum, 0) + 1);
                }
            }

            for (int k = 0; k < nums3.length; k++) {
                for (int l = 0; l < nums4.length; l++) {
                    int sum = nums3[k] + nums4[l];
                    int compliment = -sum;
                    result += sumToFrequencyMap.getOrDefault(compliment, 0);
                }
            }

            return result;
        }

        /**
         * approach : brute force
         * <p>
         * time complexity : O(n^4)
         * space complexity : O(1)
         */
        private int solutionBF(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int result = 0;

            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    for (int k = 0; k < nums3.length; k++) {
                        for (int l = 0; l < nums4.length; l++) {
                            if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                                result++;
                            }
                        }
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
