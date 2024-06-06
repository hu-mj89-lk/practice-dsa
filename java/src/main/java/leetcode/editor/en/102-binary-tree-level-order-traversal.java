package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem : 102
 * Title : Binary Tree Level Order Traversal
 */
class Driver_102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            // return new Solution2().levelOrder(root);
            return new Solution1().levelOrder(root);
        }

        /**
         * approach : using stack (recursion)
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private static class Solution1 {
            private final List<List<Integer>> result = new ArrayList<>();

            private List<List<Integer>> levelOrder(TreeNode root) {
                if (root == null) {
                    return List.of();
                }

                preOrder(root, 0);

                return result;
            }

            private void preOrder(TreeNode node, int level) {
                List<Integer> currLevel;
                if (result.size() == level) {
                    result.add((currLevel = new ArrayList<>()));
                } else {
                    currLevel = result.get(level);
                }

                currLevel.add(node.val);

                if (node.left != null) {
                    preOrder(node.left, level + 1);
                }
                if (node.right != null) {
                    preOrder(node.right, level + 1);
                }
            }
        }

        /**
         * approach : using queue
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private static class Solution2 {
            private List<List<Integer>> levelOrder(TreeNode root) {
                if (root == null) {
                    return List.of();
                }

                List<List<Integer>> result = new ArrayList<>();

                List<Integer> currLevel = new ArrayList<>();
                Queue<TreeNode> currQueue = new LinkedList<>();
                currQueue.offer(root);

                Queue<TreeNode> nextQueue = new LinkedList<>();

                while (!currQueue.isEmpty()) {
                    TreeNode curr = currQueue.poll();
                    currLevel.add(curr.val);

                    if (curr.left != null) {
                        nextQueue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        nextQueue.offer(curr.right);
                    }

                    if (currQueue.isEmpty()) {
                        Queue<TreeNode> temp = currQueue;
                        currQueue = nextQueue;
                        nextQueue = temp;

                        result.add(currLevel);
                        currLevel = new ArrayList<>();
                    }
                }

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
