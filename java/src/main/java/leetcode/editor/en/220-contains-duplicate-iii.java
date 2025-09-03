package leetcode.editor.en;

/**
 * Problem : 220
 * Title : Contains Duplicate III
 */
class Driver_220 {
    public static void main(String[] args) {
        new Driver_220().new Solution().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//            return solutionMy(nums, indexDiff, valueDiff);
            return false;
        }

//        private boolean solutionMy(int[] nums, int indexDiff, int valueDiff) {
//            // determine offset for (i,j) pair from target (valueDiff)
//            BiFunction<Integer, Integer, Integer> offsetFromValueDiff = (valI, valJ) -> valueDiff - Math.abs(valI - valJ);
//
//            Map<Integer, Integer> slidingWindow = new HashMap<>();
//
//            for (int prev = 0, i = 1; i < nums.length; i++) {
//                int upperBound = Math.min(i + indexDiff + 1, nums.length - 1);
//                for (int j = i + 1; j < upperBound; j++) {
//                    // offset of (prev,j) pair from valueDiff
//                    Integer offsetPrevJ = slidingWindow.getOrDefault(j, offsetFromValueDiff.apply(nums[prev], nums[j]));
//                    int offsetIJ;
//                    if (nums[i] > nums[prev]) {
//                        offsetIJ;
//                    }
//
//                    slidingWindow.put(j, offsetIJ);
//                    if (slidingWindow.size() > indexDiff) {
//                        slidingWindow.remove(i - indexDiff);
//                    }
//                }
//            }
//
//            return false;
//        }

        /**
         * approach : naive; time limit exceeded
         * time complexity : O(n*indexDiff)
         * space complexity : O(1)
         */
        private boolean solutionTLE(int[] nums, int indexDiff, int valueDiff) {
            for (int i = 0; i < nums.length; i++) {
                int lowerBound = Math.max(i - indexDiff, 0);
                for (int j = i - 1; j >= lowerBound; j--) {
                    if (Math.abs(nums[i] - nums[j]) <= valueDiff)
                        return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
