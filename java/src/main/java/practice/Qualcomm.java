package practice;

/**
 * Given a tree, find the number of balanced nodes in this tree.
 * A node is balanced, if all the subtrees of this node contain the same number of nodes.
 * <p>
 * Input
 * <p>
 * >        5
 * >    6          7
 * > 1     2    3
 * <p>
 * <p>
 * Output
 * 5
 */
public class Qualcomm {

    public static void main(String[] args) {
        Node one = new Node(1, null);
        Node two = new Node(2, null);
        Node three = new Node(3, null);

        Node six = new Node(6, new Node[]{
                one, two
        });
        Node seven = new Node(7, new Node[]{
                three
        });
        Node five = new Node(5, new Node[]{
                six, seven
        });

        int[] result = countBalancedNodes(five);

        System.out.printf("Result :: %d", result[0]);
    }

    private static int[] countBalancedNodes(Node root) {
        if (root.children == null || root.children.length == 0) {
            return new int[]{1, 1};
        }

        boolean isBalanced = true;
        int[] prevResult = countBalancedNodes(root.children[0]);

        int balancedNodes = prevResult[0];
        int countNodes = prevResult[1];

        int prev = prevResult[1];
        for (int i = 1; i < root.children.length; i++) {
            int[] currResult = countBalancedNodes(root.children[i]);

            balancedNodes += currResult[0];
            countNodes += currResult[1];

            isBalanced = isBalanced && (prev == currResult[1]);
        }

        if (isBalanced)
            balancedNodes += 1;

        return new int[]{balancedNodes, countNodes + 1};
    }

    private static class Node {
        int val;
        Node[] children;

        public Node(int val, Node[] children) {
            this.val = val;
            this.children = children;
        }
    }

}

