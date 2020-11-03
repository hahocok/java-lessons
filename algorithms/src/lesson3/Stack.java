package lesson3;

public class Stack<E> {
    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    public boolean push(E value) {
        if (isFull()) {
            return false;
        }

        data[size++] = value;
        return true;
    }

    public E pop() {
        return data[--size];
    }

    public E peek() {
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
