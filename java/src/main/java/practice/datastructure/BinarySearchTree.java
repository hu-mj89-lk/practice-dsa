package practice.datastructure;

class BinarySearchTree {

    private Node root;

    public void add(int key) {

    }

    public boolean contains(int key) {
        return false;
    }

    public void remove(int key) {

    }

    private static class Node {
        private final int key;
        private Node left;
        private Node right;

        private Node(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }
}

class Driver {
    public static void main(String[] args) {

    }
}