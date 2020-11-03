package lesson3;

public class Queue<E> {
    private static final int DEFAULT_FRONT = 0;
    private static final int DEFAULT_REAR = -1;
    private final int maxSize;
    private final E[] data;
    private int front;
    private int rear;
    private int items;

    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        data = (E[]) new Object[maxSize];
        front = DEFAULT_FRONT;
        rear = DEFAULT_REAR;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if(rear == maxSize - 1) {
            rear = DEFAULT_REAR;
        }
        data[++rear] = value;
        if (!isFull()) {
            items++;
        }
        return true;
    }

    public E remove() {
        E temp = data[front++];
        if(front == maxSize) {
            front = DEFAULT_FRONT;
        }
        items--;
        return temp;
    }

    public E peek() {
        return data[front];
    }
}
