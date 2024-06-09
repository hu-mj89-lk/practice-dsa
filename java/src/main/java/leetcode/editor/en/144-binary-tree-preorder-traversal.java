package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Problem : 144
 * Title : Binary Tree Preorder Traversal
 */
class Driver_144 {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            // return new Solution1().preorderTraversal(root);
            return new Solution2().preorderTraversal(root);
        }

        /**
         * approach : iterative w/ stack
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private static class Solution2 {
            private List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> result = new LinkedList<>();

                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);

                while (!stack.isEmpty()) {
                    TreeNode curr = stack.pop();
                    if (curr == null) {
                        continue;
                    }

                    // process self
                    result.add(curr.val);

                    // process children
                    stack.push(curr.right);
                    stack.push(curr.left);
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
            private List<Integer> preorderTraversal(TreeNode root) {
                return preorder(root);
            }

            private List<Integer> preorder(TreeNode node) {
                if (node == null) {
                    return List.of();
                }

                List<Integer> result = new LinkedList<>();

                // process self
                result.add(node.val);

                // process left children
                result.addAll(preorder(node.left));
                result.addAll(preorder(node.right));

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
