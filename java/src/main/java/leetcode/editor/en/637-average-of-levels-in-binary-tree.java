package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem : 637
 * Title : Average of Levels in Binary Tree
 */
class Driver_637 {
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
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) {
                return List.of();
            }

            List<Double> result = new ArrayList<>();
            long currLevelSum = 0;
            int currLevelCount = 0;
            Queue<TreeNode> currQueue = new LinkedList<>();
            currQueue.offer(root);

            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!currQueue.isEmpty()) {
                TreeNode curr = currQueue.poll();
                currLevelSum += curr.val;
                currLevelCount++;

                if (curr.left != null) {
                    nextQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nextQueue.offer(curr.right);
                }

                if (currQueue.isEmpty()) {
                    result.add((double) currLevelSum / currLevelCount);

                    Queue<TreeNode> temp = currQueue;
                    currQueue = nextQueue;
                    nextQueue = temp;

                    currLevelSum = currLevelCount = 0;
                }
            }

            return result;
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
