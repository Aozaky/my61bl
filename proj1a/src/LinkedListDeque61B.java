import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    Node sentinel;
    int size;

    private class Node {
        private final T item;
        private Node next;
        private Node prev;

        public Node(T x) {
            item = x;
            next = null;
            prev = null;
        }
    }

    public LinkedListDeque61B() {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node node = new Node(x);
        node.next = sentinel.next;
        node.prev = sentinel;
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node node = new Node(x);
        node.next = sentinel;
        node.prev = sentinel.prev;
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            returnList.add(p.item);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T temp = sentinel.next.item;
        sentinel.next  = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return temp;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return temp;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node p = sentinel;
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
        } else {
            for (int i = 0; i <= size - 1 - index; i++) {
                p = p.prev;
            }
        }
        return p.item;
    }

    private Node getRecursiveHelper(int index) {
        if (index == 0) {
            return sentinel.next;
        }
        if (index < size / 2) {
            return getRecursiveHelper(index - 1).next;
        } else {
            return getRecursiveHelper(index + 1).prev;
        }
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index).item;
    }
}
