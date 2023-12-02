public class Node<E extends Comparable<E>> {
    Node<E> parent; //ohne private oder public kann man die Variablen in SortedBinaryTree nutzen
    Node<E> left;
    Node<E> right;
    private E key;

    public Node(E key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public E getKey() {
        return key;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
