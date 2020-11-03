package lesson3;

public class Deque<E> {
    private static final int DEFAULT_REAR = -1;
    private static final int DEFAULT_FRONT = 0;

    private final E[] data;
    private int size;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public Deque(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.front = DEFAULT_FRONT;
        this.rear = DEFAULT_REAR;
    }

    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (front == 0) {
            front = data.length;
        }
        data[--front] = value;
        size++;
        return true;
    }

    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (rear == lastIndex()) {
            rear = DEFAULT_REAR;
        }
        data[++rear] = value;
        size++;
        return true;
    }

    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        if (front == data.length) {
            front = DEFAULT_FRONT;
        }

        E value = data[front++];
        size--;
        return value;
    }

    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (rear == DEFAULT_REAR) {
            rear = lastIndex();
        }

        E value = data[rear--];
        size--;
        return value;
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

    private int lastIndex() {
        return data.length - 1;
    }
}
