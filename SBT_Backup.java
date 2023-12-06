package worksheetk;

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
		root = insert(root, key);
		size++; // Gibt die Anzahl der Elemente im Baum zurück
	}

	private Node<E> insert(Node<E> root, E key) {
		if (root == null) {
			return new Node<>(key);
		}

		if (key.compareTo(root.getKey()) < 0) {
			root.left = insert(root.left, key);
			root.left.setParent(root);
		} else if (key.compareTo(root.getKey()) > 0) {
			root.right = insert(root.right, key);
			root.right.setParent(root);
		}

		return root;
	}

	public int size() {
		return size; // Gibt die Anzahl der Elemente im Baum zurück
	}

	@Override
	public Iterator<Node<E>> iterator() {
		return new Iterator<Node<E>>() {
			private Node<E> current = min(root);// Liegt der Startpunkt für Iterator fest

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Node<E> next() {
				if (!hasNext()) {
					throw new java.util.NoSuchElementException(); // Ausnahme
				}

				Node<E> result = current; // Speichern den aktuellen Knoten

				if (current.right != null) {
					current = min(current.right); // falls der aktuelle Knoten ein rechtes Kind hat, wird es als
													// aktueller Knoten gespeichert.
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

	public Node<E> find(E key) {
		Node<E> current = root;

		if (root == null) {
			return null;
		}
		if (root.getKey() == key) {
			return root;
		} else {
			if (key.compareTo(current.getKey()) <0 ) {
				return find(current.left);
		}
	}

	}

	private Node<E> min(Node<E> node) {
		while (node.left != null) { // Gibt den Knoten mit dem kleinsten Schlüssel im Unterbaum zurück
			node = node.left;
		}
		return node;
	}
}
