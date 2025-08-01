package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] items;
    private int first;
    private int last;
    private int size;
    private int max;

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        first = 0;
        last = 0;
        size = 0;
        max = 8;
    }

    private class ArrayDequeIterator implements Iterator<T> {

        private int curr = 0;

        @Override
        public boolean hasNext() {
            return curr != size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = items[Math.floorMod(first + curr, max)];
            curr++;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private T[] copy(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = this.get(i);
        }
        return newItems;
    }

    private void resizeUp() {
        items = this.copy(max * 2);
        max *= 2;
        first = 0;
        last = size;
    }

    private void resizeDown() {
        items = this.copy(max / 2);
        max /= 2;
        first = 0;
        last = size;
    }

    @Override
    public void addFirst(T x) {
        if (this.isFull()) {
            this.resizeUp();
        }
        if (this.isEmpty()) {
            last = Math.floorMod(last + 1, max);
        } else {
            first = Math.floorMod(first - 1, max);
        }
        items[first] = x;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (this.isFull()) {
            this.resizeUp();
        }
        items[last] = x;
        last = Math.floorMod(last + 1, max);
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            returnList.add(this.get(i));
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return max == size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size < max / 4) {
            this.resizeDown();
        }
        if (this.isEmpty()) {
            return null;
        }
        T value = this.get(0);
        items[first] = null;
        first = Math.floorMod(first + 1, max);
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (size < max / 4) {
            this.resizeDown();
        }
        if (this.isEmpty()) {
            return null;
        }
        T value = this.get(size - 1);
        last = Math.floorMod(last - 1, max);
        items[last] = null;
        size--;
        return value;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[Math.floorMod(first + index, max)];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Deque61B<?> other)) {
            return false;
        }
        if (size != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.toList().toString();
    }
}
