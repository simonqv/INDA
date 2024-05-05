/**
 * Tree class.
 *
 * @author
 * @version 2020-02-17
 */

public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> right = null;
        private Node<T> left = null;

        /**
         * Creates a node
         * @param data value in node
         */
        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * Creates a tree
     */
    public Tree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Searches through the tree iteratively.
     * @param elem Element to search for.
     * @return true if found, false if not found
     */
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

    /**
     * Inserts element, iteratively.
     * @param elem element to insert.
     * @return true if inserted, false if already added.
     */
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

    /**
     *
     * @return size variable.
     */
    public int size() {
        return size;
    }

    /**
     * Gets the height of the tree, recursively.
     * @return height from root, root starting at 0.
     */
    public int height() {
        if (root == null) {
            return 0;
        }
        Node<T> node = root;
        return Math.max(height(node.left), height(node.right) );

    }

    /**
     * helper to height method.
     * @param node what node to continue at
     * @return Max value of branch to the right or left, with 1 incrementing counter.
     */
    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * Calls helper method
     * @return number of leaves
     */
    public int leaves() {
        return leaves(root);
    }

    /**
     * if leaf return 1, if not return 0.
     * @param node current node
     * @return add recursively number of leaves.
     */
    private int leaves(Node<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        else return leaves(node.left) + leaves(node.right);
    }

    /**
     * Calls helper method with a StringBuilder.
     * @return string representation of tree.
     */
    public String toString() {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<T> node = root;
        toString(sb, node);
        return sb.append("]").toString();
    }

    /**
     * Adds value of node to the StringBuilder and recursively traverses the tree.
     * @param sb StringBuilder object.
     * @param node The current node.
     */
    private void toString(StringBuilder sb, Node<T> node) {
        if (node.left != null) {
            toString(sb, node.left);
            sb.append(", ");
        }

        // in order traversal
        sb.append(node.data);

        if (node.right != null) {
            sb.append(", ");
            toString(sb, node.right);
        }
    }


}
