package com.tupurpcheung.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title AVLTree
 * @package tree
 * @description 平衡二叉树：对于任意一个节点，左子树和右子树的高度差不能超过1（相较于叶子节点的深度差值不可大于1的条件而言，宽松许多）
 * <p>
 * 标注节点的高度
 * 计算平衡因子（左子树高度减去右子树高度结果的绝对值）
 * <p>
 * 满二叉树：所有非叶子节点的子节点必定全是满（存在）的，属于平衡二叉树。
 * 完全二叉树：空出的节点必在树的右下角位置，最大的深度与最小的深度差值不会大于1，属于平衡二叉树。
 * 线段树：空出的节点不一定处于树的右下角位置，但最大的深度与最小的深度差值也不会大于1，属于平衡二叉树。
 * @date 2018/12/28 15:50
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }


    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断该二叉树是否是一棵二分搜索树，二分搜索树的中序遍历结果是有序的
     */
    public boolean isBST() {
        /**中序遍历二叉树*/
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);

        /**判断是否为二分搜索树*/
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * 判断该二叉树是否是一棵平衡二叉树
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 判断以Node为根的二叉树是否是一棵平衡二叉树（左右子树的高度差小于1），递归算法
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced : " + balanceFactor);
            return false;
        } else {
            return isBalanced(node.left) && isBalanced(node.right);
        }

    }

    /**
     * 节点高度值获取
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 节点平衡因子的获取
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }


    public boolean contains(K key) {
        return contains(root, key);
    }


    /**
     * 二分搜索树的前序遍历
     * 父节点被最新访问
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 二分搜索树的中序遍历
     * 在中间访问父节点
     * 会将节点由小到大顺序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 二分搜索树的后序遍历
     * 最后访问父节点（内存管理）
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> quere = new LinkedList<>();
        quere.add(root);
        while (!quere.isEmpty()) {
            Node cur = quere.remove();
            System.out.println(cur.key);
            if (cur.left != null) {
                quere.add(cur.left);
            }
            if (cur.right != null) {
                quere.add(cur.right);
            }
        }
    }


    /**
     * 寻找二分搜索树的最小元素
     */
    public K minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).key;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }


    public void remove(K key) {

        root = remove(root, key);

    }

    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {

            /**待删除节点左子树为空*/
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            /**待删除节点右子树为空*/
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
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

    /**
     * 从二分搜索树中删除最小值所在节点，并返回最小值
     */
    public K removeMin() {
        K ret = minimum();
        root = removeMin(root);
        return ret;
    }

    public Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);

        return node;
    }


    /**
     * 寻找二分搜索树的最大元素
     */
    public K maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).key;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 使用递归向以Node未根的二分搜索树中插入元素e
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        /**以当前节点为根，添加了一个新节点，需要更新此节点的高度值*/
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        /**计算平衡因子*/
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println(" unbalanced : " + balanceFactor);
            //TODO 平衡树旋转
        }

        return node;

    }


    //对节点y进行向右旋转操作，返回旋转后新的根节点x
    //              y
    //            /  \
    //         x      T4                                     x
    //       /  \                向右旋转（y）             /   \
    //     z     T3            --------->                z      y
    //   /  \                                          / \     / \
    // T1    T2                                      T1  T2   T3  T4
    //
    //
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;

        x.right = y;
        y.left = t3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right));
        x.height = Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    //对节点y进行向左旋转操作，返回旋转后新的根节点x
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t3 = x.left;

        x.left = y;
        y.right = t3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right));
        x.height = Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    private boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;

        } else if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);

        } else {
            return contains(node.right, key);
        }
    }

    public Node getNode(K key) {
        return getNode(root, key);
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;

        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);

        } else {
            return getNode(node.right, key);
        }
    }

    public V getValue(K key) {
        return getValue(root, key);
    }

    private V getValue(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;

        } else if (key.compareTo(node.key) < 0) {
            return getValue(node.left, key);

        } else {
            return getValue(node.right, key);
        }
    }

    /**
     * 以Node为根的二分搜索树的前序遍历
     */
    private void preOrder(Node node) {

        if (node == null) {
            return;
        }
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);


    }

    /**
     * 以Node为根的二分搜索树的中序遍历
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    /**
     * 以Node为根的二分搜索树的后序遍历
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }


        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        generateBSTString(root, 0, res);

        return res.toString();
    }


    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.key + ":" + node.value + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }


    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
