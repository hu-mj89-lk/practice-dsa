package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem : 429
 * Title : N-ary Tree Level Order Traversal
 */
class Driver_429 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return List.of();
            }
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> currlevel = new ArrayList<>();
            Queue<Node> currQueue = new LinkedList<>();
            currQueue.offer(root);

            Queue<Node> nextQueue = new LinkedList<>();

            while (!currQueue.isEmpty()) {
                Node curr = currQueue.poll();
                currlevel.add(curr.val);

                for (Node node : curr.children) {
                    nextQueue.offer(node);
                }

                if (currQueue.isEmpty()) {
                    Queue<Node> temp = currQueue;
                    currQueue = nextQueue;
                    nextQueue = temp;

                    result.add(currlevel);
                    currlevel = new ArrayList<>();
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
