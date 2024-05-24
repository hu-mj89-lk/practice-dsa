package leetcode.editor.en;

/**
 * Problem : 2415
 * Title : Reverse Odd Levels of Binary Tree
 */
class Driver_2415 {
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
        public TreeNode reverseOddLevels(TreeNode root) {
            internal(root.left, root.right, 0);
            return root;
        }

        private void internal(TreeNode left, TreeNode right, int parentLevel) {
            if (left == null || right == null)
                return;

            if (parentLevel % 2 == 0) {
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            }

            internal(left.left, right.right, parentLevel + 1);
            internal(left.right, right.left, parentLevel + 1);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    private static class TreeNode {
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
