package org.tupurpcheung.learn.structure.map;

/**
 * All rights Reserved, Designed By www.yingfeng365.com
 *
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title BSTMap
 * @package map
 * @description ${TODO}
 * @date 2018/12/17 10:51
 * @copyright 2018 www.yingfeng365.com
 * 注意：本内容仅限于 江苏灜沣信息科技有限公司，禁止外泄以及用于其他的商业
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {


    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {

        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (node.key.compareTo(key) < 0) {
            node.right = add(node.right, key, value);
        } else if (node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }
     return null;
    }

    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }
        if(node.key.compareTo(key) > 0){
            node.left = remove(node.left,key);
            return node;
        }else if(node.key.compareTo(key) < 0 ){
            node.right = remove(node.right,key);
            return node;
        }else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }

            Node successor = removeMin(node.right);

            successor.left = node.left;
            successor.right = node.right;

            node.right = null;
            node.left = null;
            return successor;

        }
    }

    public Node removeMin(Node node){
        Node ret = minimum();
        root = removeMin(root);
        return ret;
    }

    public Node  minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root);
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }


    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (node.key.compareTo(key) < 0) {
            return getNode(node.right, key);
        } else {
            return getNode(node.left, key);
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root,key);
        if(node == null){
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = value;
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
