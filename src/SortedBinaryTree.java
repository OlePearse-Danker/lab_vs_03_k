import java.util.Iterator;

public class SortedBinaryTree<E extends Comparable<E>> implements Iterable<Node<E>> {
    private Node<E> root;
    private int size;

    public SortedBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void insert(E key) {
        root = insertRec(root, key);
        size++; // increment size
    }

    private Node<E> insertRec(Node<E> root, E key) {
        if (root == null) {
            return new Node<>(key);
        }

        if (key.compareTo(root.getKey()) < 0) {
            root.left = insertRec(root.left, key);
            root.left.setParent(root);
        } else if (key.compareTo(root.getKey()) > 0) {
            root.right = insertRec(root.right, key);
            root.right.setParent(root);
        }

        return root;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return new Iterator<Node<E>>() {
            private Node<E> current = min(root);

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node<E> next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }

                Node<E> result = current;

                if (current.right != null) {
                    current = min(current.right);
                } else {
                    while (current.parent != null && current == current.parent.right) {
                        current = current.parent;
                    }
                    current = current.parent;
                }

                return result;
            }
        };
    }
    private Node<E> min(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
