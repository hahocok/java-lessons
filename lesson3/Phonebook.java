package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook<K extends String, V extends String> {
    private final Map<K, Set<V>> phonebook = new HashMap<>();

    public void add(K key, V phone) {
        Set<V> phones = get(key);
        phones.add(phone);
        phonebook.put(key, phones);
    }

    public Set<V> get(K key) {
        return phonebook.getOrDefault(key, new HashSet<>());
    }
}
