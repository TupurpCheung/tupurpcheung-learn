package com.tupurpcheung.structure.tree;

import java.util.TreeMap;

/**
 * @author @tuprup
 * @version V1.1
 * @projectName structure
 * @title Trie
 * @package tree
 * @description trie  ----> 字典树，前缀树（是一个多叉树）
 * 通常只用来处理字符串
 * 可以做到查询每个条目的时间复杂度，和字典中一共有多少个条目无关，而只与条目的长度有关
 */
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }


    /**
     * 向Trie中添加一个新的单词 word
     */
    public void add(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);

        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }

    }

    /**
     * 单词word是否在trie中
     */
    public boolean contains(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            } else {
                cur = cur.next.get(c);
            }
        }
        return cur.isWord;

    }

    /**
     * 在trie中是否有单词以prefix为前缀
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            } else {
                cur = cur.next.get(c);
            }
        }
        return true;

    }
}
