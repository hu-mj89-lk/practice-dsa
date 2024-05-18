package leetcode.editor.en;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Problem : 349
 * Title : Intersection of Two Arrays
 */
class Driver_349 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            for (int i : nums1) {
                set1.add(i);
            }
            Set<Integer> set2 = new HashSet<>();
            for (int i : nums2) {
                set2.add(i);
            }

            if (set1.size() < set2.size())
                return setIntersection(set1, set2);
            else
                return setIntersection(set2, set1);
        }

        private int[] setIntersection(Set<Integer> smaller, Set<Integer> larger) {
            Iterator<Integer> itr = smaller.iterator();
            while (itr.hasNext()) {
                if (larger.add(itr.next())) {
                    itr.remove();
                }
            }

            int[] result = new int[smaller.size()];
            int idx = 0;
            Iterator<Integer> itr1 = smaller.iterator();
            while (itr1.hasNext()) {
                result[idx++] = itr1.next();
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
