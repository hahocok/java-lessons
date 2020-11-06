package lesson8;

public interface HashTable<K, V>  {
    boolean put(K key, V value);
    V get(K key);
    boolean contains(K key);
    V remove(K key);
    void display();
    boolean isEmpty();
    int size();
    boolean isFull();

    interface Entry<K, V> {
        K getKey();
        void setKey(K key);

        V getValue();
        void setValue(V value);
    }
}
