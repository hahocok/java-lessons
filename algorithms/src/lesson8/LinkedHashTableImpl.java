package lesson8;

public class LinkedHashTableImpl<K, V> extends HashTableImpl<K, V> {
    public LinkedHashTableImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean put(K key, V value) {
        if (isFull()) {
            return false;
        }
        int index = hashFunc(key);
        Node<K, V> node = null;

        if (data[index] != null) {
            node = data[index];

            if (node.key.equals(key)) {
                node.value = value;
                return true;
            }

            while (node.hasNext()) {
                node = node.next;
                if (node.key.equals(key)) {
                    node.value = value;
                    return true;
                }
            }
        }

        final Node<K, V> newNode = new Node<K, V>(key, value);

        if (node == null) {
            data[index] = newNode;
        } else {
            node.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        V result = null;
        Node<K, V> node = data[index];
        if (node.key.equals(key)) {
            data[index] = node.next;
            result = node.value;
        }

        while (result == null && node.hasNext()) {
            Node<K, V> parentNode = node;
            node = node.next;
            if (node.key.equals(key)) {
                parentNode.next = node.next;
                result = node.value;
                break;
            }
        }

        if (result != null) {
            size--;
        }

        return result;
    }

    @Override
    protected int indexOf(K key) {
        int index = hashFunc(key);
        if (data[index] != null) {
            Node<K, V> current = data[index];
            if (current.getKey().equals(key)) {
                return index;
            }

            while (current.hasNext()) {
                current = current.next;
                if (current.getKey().equals(key)) {
                    return index;
                }
            }
        }

        return -1;
    }
}
