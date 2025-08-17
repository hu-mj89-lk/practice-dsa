package leetcode.editor.en;

/**
 * Problem : 108
 * Title : Convert Sorted Array to Binary Search Tree
 */
class Driver_108 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // @formatter:off
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    // @formatter:on
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return solution1(nums);
        }

        /**
         * using loop
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        public TreeNode solution2(int[] nums) {
            return null;
        }

        /**
         * using recursion
         * <p>
         * time complexity : O(n)
         * space complexity : O(log(n))
         */
        public TreeNode solution1(int[] nums) {
            return solution1Internal(nums, 0, nums.length - 1);
        }

        private TreeNode solution1Internal(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            } else if (start == end) {
                return new TreeNode(nums[start]);
            }

            int mid = (start + end) >> 1;

            TreeNode leftSubtree = solution1Internal(nums, start, mid - 1);
            TreeNode rightSubtree = solution1Internal(nums, mid + 1, end);

            return new TreeNode(nums[mid], leftSubtree, rightSubtree);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}