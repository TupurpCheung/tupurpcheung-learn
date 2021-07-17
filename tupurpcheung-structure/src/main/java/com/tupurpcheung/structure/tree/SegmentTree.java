package com.tupurpcheung.structure.tree;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title SegementTree
 * @package tree
 * @description 线段树
 * 不是完全二叉树
 * 是平衡二叉树（最大深度与最小深度差不超过1）
 * <p>
 * 对于满二叉树而言，每一层节点都大致等于前面所有层节点之和。
 * 所以，如果区间内有n（n=2的k次方）个元素，则数组表示需要2n的空间
 * 如果区间内有n（n=2的k次方  + 1 ）个元素，则数组表示需要4n的空间
 */
public class SegmentTree<E> {


    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间为[left,right]的线段树
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {

        if (left == right) {
            tree[treeIndex] = data[left];
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }


    /**
     * 返回区间[queryLeft,queryRight]的值
     */
    public E query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= data.length
                || queryRight < 0 || queryRight >= data.length || queryLeft > queryRight) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    /**
     * 在以treeIndex为根节点的线段树[left....right]的范围中，搜索[queryLeft...queryRight]的区间值
     */
    private E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }
        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryLeft > mid + 1) {
            return query(rightTreeIndex, mid + 1, right, queryLeft, queryRight);
        } else if (queryRight <= mid) {
            return query(leftTreeIndex, left, mid, queryLeft, queryRight);
        }

        E leftResult = query(leftTreeIndex, left, mid, queryLeft, mid);
        E rightResult = query(rightTreeIndex, mid + 1, right, mid + 1, queryRight);

        return merger.merge(leftResult, rightResult);
    }

    /**
     * 更新index位置的值
     */
    public void set(int index, E e) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;

        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 更新线段树中以treeIndex为根的index的值
     */
    private void set(int treeIndex, int left, int right, int index, E e) {
        if (left == right) {
            tree[treeIndex] = e;
            return;
        }

        int mid = left + (right - left) / 2;

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, right, index, e);
        } else {
            set(leftTreeIndex, left, mid, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }


    public int getSize() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();

        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {

            }
        }

        return res.toString();
    }

    /**
     * 当前索引的左孩子索引
     */
    private int leftChild(int index) {

        return 2 * index + 1;
    }


    /**
     * 当前索引的右孩子索引
     */
    private int rightChild(int index) {

        return 2 * (index + 1);
    }

}
