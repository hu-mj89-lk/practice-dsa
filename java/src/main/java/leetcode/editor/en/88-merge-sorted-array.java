package leetcode.editor.en;

/**
 * Problem : 88
 * Title : Merge Sorted Array
 */
class Driver_88 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int last1 = m - 1;
            int last2 = n - 1;
            int idx = nums1.length - 1;

            while (idx >= 0) {
                if (last1 < 0) {
                    nums1[idx--] = nums2[last2--];
                } else if (last2 < 0) {
                    nums1[idx--] = nums1[last1--];
                } else {
                    if (nums2[last2] >= nums1[last1]) {
                        nums1[idx--] = nums2[last2--];
                    } else {
                        nums1[idx--] = nums1[last1--];
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
