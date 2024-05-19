package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 350
 * Title : Intersection of Two Arrays II
 */
class Driver_350 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] smaller, larger;
            if (nums1.length < nums2.length) {
                smaller = nums1;
                larger = nums2;
            } else {
                smaller = nums2;
                larger = nums1;
            }

            int k = 0;
            Map<Integer, Integer> ftSmaller = buildFrequencyTable(smaller);
            for (int num : larger) {
                if (!ftSmaller.containsKey(num) || ftSmaller.get(num) == 0)
                    continue;

                smaller[k++] = num;
                ftSmaller.put(num, ftSmaller.get(num) - 1);
            }

            if (k == 0) {
                return new int[]{};
            } else {
                int[] result = new int[k];
                System.arraycopy(smaller, 0, result, 0, result.length);
                return result;
            }
        }

        private Map<Integer, Integer> buildFrequencyTable(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            return map;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
