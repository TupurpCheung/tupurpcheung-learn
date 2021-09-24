package org.tupurpcheung.learn.structure.heap;


import org.tupurpcheung.learn.structure.array.Array;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title BinaryHeap
 * @package heap
 * @description 二叉堆是一棵完全二叉树：把元素顺序排列成树的形状（不一定要求是满二叉树）
 * 最大堆：根节点是最大的元素，每个节点都大于等于其子节点
 * 最小堆：根节点是最小的元素，每个节点都小于等于其子节点
 * <p>
 * 如果使用数组存储二叉堆
 * 索引从0开始有如下规律：
 * parent(i) = （i-1）/2
 * left child(i) = 2*1+1
 * right child(i) = 2*i+2
 * <p>
 * 索引从1开始有如下规律：
 * parent(i) = i/2
 * left child(i) = 2*1
 * right child(i) = 2*1+1
 * @date 2018/12/17 15:25业
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    /**
     * 向堆中添加元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.size() - 1);
    }


    /**
     * 元素的上浮
     */
    private void siftUp(int key) {
        while (key > 0 && data.get(parent(key)).compareTo(data.get(key)) < 0) {
            data.swap(key, parent(key));
            key = parent(key);
        }
    }

    /**
     * 取出堆中的最大元素
     */
    public E extractMax() {
        E ret = findMax();
        data.set(0, data.removeLast());
        siftDown(0);
        return ret;
    }

    public E findMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("heap is empty!");
        }
        return data.getFirst();
    }

    /**
     * 元素的下沉
     */
    private void siftDown(int key) {
        while (leftChild(key) < data.size()) {
            /**data[maxChildIndex] 是左右孩子中最大的值*/
            int maxChildIndex = leftChild(key);

            /**右孩子有值*/
            if (maxChildIndex + 1 < data.size() && data.get(maxChildIndex + 1).compareTo(data.get(maxChildIndex)) > 0) {
                maxChildIndex = rightChild(key);
            }
            if (data.get(key).compareTo(data.get(maxChildIndex)) >= 0) {
                break;
            }

            data.swap(key, maxChildIndex);
            key = maxChildIndex;
        }

    }

    /**
     * 取出最大元素后，放入一个新元素
     * <p>
     * 替换堆顶元素，然后进行siftDown操作
     */
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**将任意数组整理成堆的形状
     *
     * 将当前数组看作一个完全二叉树，从最后一个非叶子节点进行计算
     * 依次从后向前进行下沉（siftDown）操作
     * */
    public void heapify(E [] arr){
        data = new Array<>(arr);
        int lastParentIndex = parent(arr.length-1) ;
        for(int i =0;i<=lastParentIndex;i++){
            siftDown(i);
        }
    }

    /**
     * 返回index索引的父亲节点
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回index索引的左节点
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回index索引的右节点
     */
    private int rightChild(int index) {
        return 2 * (index + 1);
    }

}
