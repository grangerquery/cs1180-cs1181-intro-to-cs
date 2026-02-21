import java.util.Iterator;

public class SingleLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int count;

    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    public boolean addFirst(E item) {
        // Add to empty list
        if (head == null) {
            head = new Node<E>(item);
            tail = head;
        }
        // Add to non-empty list
        else {
            Node<E> newNode = new Node<E>(item);
            newNode.next = head;
            head = newNode;
        }
        count++;
        return true;
    }

    public boolean addLast(E item) {
        // Add to empty list
        if (head == null) {
            head = new Node<E>(item);
            tail = head;
        }
        // Add to non-empty list
        else {
            // Find the last list element
            tail.next = new Node<E>(item);
            tail = tail.next;
        }
        count++;
        return true;
    }

    public void add(int index, E item) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // Special case 1: First item
        if (index == 0) {
            this.addFirst(item);
            return;
        }

        // Special case 2: Last item
        if (index == count) {
            this.addLast(item);
            return;
        }

        // Find the node before the insertion point
        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        // Insert the new node
        Node<E> newNode = new Node<>(item);
        newNode.next = current.next;
        current.next = newNode;
        count++;
    }

    public void remove(int index) {

    }

    @Override
    public String toString() {
        String result = "[";
        Node<E> current = head;
        while (current != null) {
            result += current.item.toString();
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        return result + "]";
    }

    public Iterator<E> iterator() {
        return new SLLIterator();
    }

    class SLLIterator implements Iterator<E> {
        private Node<E> nextItem;

        public SLLIterator() {
            nextItem = head;
        }

        @Override
        public boolean hasNext() {
            if (nextItem != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            E returnValue = nextItem.item;
            nextItem = nextItem.next;
            return returnValue;
        }
    }

    class Node<E> {
        public E item;
        public Node<E> next;

        public Node(E newItem) {
            item = newItem;
            next = null;
        }
    }
}
