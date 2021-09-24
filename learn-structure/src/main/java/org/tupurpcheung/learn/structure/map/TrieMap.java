package org.tupurpcheung.learn.structure.map;

import java.util.List;
import java.util.TreeMap;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title TrieMap
 * @package map
 * @description 字典树实现map，以测试文章的词频统计
 * @date 2018/12/26 16:35
 */
public class TrieMap implements Map<String, Integer> {

    private class Node {
        public int frequency;
        public TreeMap<Character, Node> next;

        public Node(int frequency) {
            this.frequency = frequency;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;
    private int size;

    public TrieMap() {
        this.root = new Node();
    }

    public TrieMap(List<String> list) {
        this();
        for (String str : list) {
            add(str, 0);
        }

    }

    @Override
    public void add(String key, Integer value) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (cur.frequency == 0) {
            size++;
        }
        cur.frequency++;
    }

    @Override
    public Integer remove(String key) {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Integer get(String key) {
        return null;
    }

    @Override
    public void set(String key, Integer value) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
