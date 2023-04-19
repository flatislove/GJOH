public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private static class Node {
        public int value;
        public Node left, right;
        public boolean color;

        public Node(int value, boolean color) {
            this.value = value;
            this.color = color;
        }
    }

    public void put(int value) {
        root = put(root, value);
        root.color = BLACK;
    }

    private Node put(Node node, int value) {
        if (node == null) {
            return new Node(value, RED);
        }

        int cmp = ((Comparable<Integer>) value).compareTo(node.value);
        if (cmp < 0) {
            node.left = put(node.left, value);
        } else if (cmp > 0) {
            node.right = put(node.right, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }
}
