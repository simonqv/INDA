

public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> right = null;
        private Node<T> left = null;

        public Node(T data) {
            this.data = data;
        }
    }
    public Tree() {
        this.root = null;
        this.size = 0;
    }

    public boolean search(T elem) {
        Node<T> node = root;
        while (node != null) {
            if (elem.compareTo(node.data) == 0) {
                return true;
            } else if (elem.compareTo(node.data) > 0) {
                node = node.right;
            } else if (elem.compareTo(node.data) < 0) {
                node = node.left;
            }
        }
        return false;
    }


    public boolean insert(T elem) {
        Node<T> node = root;
        if (root == null) {
            root = new Node<>(elem);
            size ++;
            return true;
        }
        while (true) {
            if (elem.compareTo(node.data) == 0) {
                return false;
            } else if (elem.compareTo(node.data) > 0) {
                if (node.right == null) {
                    node.right = new Node<>(elem);
                    size ++;
                    return true;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = new Node<>(elem);
                    size ++;
                    return true;
                } else {
                    node = node.left;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public int height() {
        if (root == null) {
            return 0;
        }
        Node<T> node = root;
        return Math.max(height(node.left), height(node.right) );

    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int leaves() {
        return leaves(root);
    }

    private int leaves(Node<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        else return leaves(node.left) + leaves(node.right);
    }

    public String toString() {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<T> node = root;
        toString(sb, node);
        return sb.append("]").toString();
    }

    private void toString(StringBuilder sb, Node<T> node) {
        if (node.left != null) {
            toString(sb, node.left);
            sb.append(", ");
        }

        sb.append(node.data);

        if (node.right != null) {
            sb.append(", ");
            toString(sb, node.right);
        }
    }


}
