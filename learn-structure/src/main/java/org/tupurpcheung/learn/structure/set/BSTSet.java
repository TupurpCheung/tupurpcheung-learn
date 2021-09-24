package org.tupurpcheung.learn.structure.set;


import org.tupurpcheung.learn.structure.tree.BinarySearchTree;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title BSTSet
 * @package set
 * @description ${TODO}
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;


    public BSTSet(){
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
