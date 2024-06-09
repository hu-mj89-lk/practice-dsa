package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Problem : 94
 * Title : Binary Tree Inorder Traversal
 */
class Driver_94 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            // return new Solution1().inorderTraversal(root);
            return new Solution2().inorderTraversal(root);
        }

        /**
         * approach : iterative w/ stack
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private static class Solution2 {
            // TODO : revisit
            private List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> result = new LinkedList<>();
                Stack<TreeNode> stack = new Stack<>();
                TreeNode curr = root;
                while (curr != null || !stack.isEmpty()) {
                    while (curr != null) {
                        stack.push(curr);
                        curr = curr.left;
                    }
                    curr = stack.pop();
                    result.add(curr.val);
                    curr = curr.right;
                }

                return result;
            }
        }

        /**
         * approach : recursive
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private static class Solution1 {
            private List<Integer> inorderTraversal(TreeNode root) {
                return inorder(root);
            }

            private List<Integer> inorder(TreeNode node) {
                if (node == null) {
                    return List.of();
                }

                List<Integer> result = new LinkedList<>();

                // process left
                result.addAll(inorder(node.left));
                // process self
                result.add(node.val);
                // process right
                result.addAll(inorder(node.right));

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
