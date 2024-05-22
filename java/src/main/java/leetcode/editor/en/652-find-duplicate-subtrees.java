package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem : 652
 * Title : Find Duplicate Subtrees
 */
class Driver_652 {
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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            return solution1(root);
        }

        private List<TreeNode> solution1(TreeNode root) {
            List<TreeNode> result = new ArrayList<>();

            Map<String, Integer> subtreesTally = new HashMap<>();
            subtreeRepresentation(root, subtreesTally, result);

            return result;
        }

        private String subtreeRepresentation(TreeNode node, Map<String, Integer> subtreesTally, List<TreeNode> result) {
            if (node == null) {
                return "";
            }

            String leftSubtree = subtreeRepresentation(node.left, subtreesTally, result);
            String rightSubtree = subtreeRepresentation(node.right, subtreesTally, result);

            String currSubtree = String.format("(%s)%s(%s)", leftSubtree, node.val, rightSubtree);

            subtreesTally.put(currSubtree, subtreesTally.getOrDefault(currSubtree, 0) + 1);
            if (subtreesTally.get(currSubtree) == 2)
                result.add(node);

            return currSubtree;
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
