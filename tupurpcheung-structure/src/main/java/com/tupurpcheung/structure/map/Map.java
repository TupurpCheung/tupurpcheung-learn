package com.tupurpcheung.structure.map;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title Map
 * @package map
 * @description 映射
 */
public interface Map<K,V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
