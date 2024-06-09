package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem : 145
 * Title : Binary Tree Postorder Traversal
 */
class Driver_145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            return new Solution1().postorderTraversal(root);
            // return new Solution2().postorderTraversal(root);
        }

        /**
         * approach : iterative w/ stack
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private static class Solution2 {
            private List<Integer> postorderTraversal(TreeNode root) {
                // TODO
                return null;
            }
        }

        /**
         * approach : recursive
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private static class Solution1 {
            private List<Integer> postorderTraversal(TreeNode root) {
                return postOrder(root);
            }

            private List<Integer> postOrder(TreeNode node) {
                if (node == null) {
                    return List.of();
                }

                List<Integer> result = new LinkedList<>();
                result.addAll(postOrder(node.left));
                result.addAll(postOrder(node.right));
                result.add(node.val);

                return result;
            }
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
