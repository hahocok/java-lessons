package lesson8;

import java.util.Optional;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    protected static class Node<K, V> implements Entry<K, V> {
        protected K key;
        protected V value;
        protected Node<K, V> next = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }
    }


    protected Node<K, V>[] data;
    protected int size;
    protected int maxSize;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[maxSize * 2];
    }

    protected int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        if (isFull()) {
            return false;
        }
        int index = hashFunc(key);
        while (data[index] != null) {
            if (data[index].key.equals(key)) {
                data[index].value = value;
                return true;
            }
            index += getStep(key);
            index %= data.length;
        }

        data[index] = new Node<>(key, value);
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        return getEntry(key)
                .map(Node::getValue)
                .orElse(null);
    }

    private Optional<Node<K, V>> getEntry(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return Optional.of(data[index]);
        }

        return Optional.empty();
    }

    protected int indexOf(K key) {
        int index = hashFunc(key);
        while (data[index] != null) {
            Node current = data[index];
            if (current.getKey().equals(key)) {
                return index;
            }
            index += getStep(key);
            index %= data.length;
        }

        return -1;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        V result = data[index].getValue();
        data[index] = null;
        size--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void display() {
        System.out.println("---------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("---------");
    }

    protected int getStep(K key) {
        return 1;
    }
}
