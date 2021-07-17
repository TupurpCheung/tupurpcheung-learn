package com.tupurpcheung.structure.tree;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title Merge
 * @package tree
 * @description 融合器
 */
public interface Merger<E> {

    E merge(E a, E b);
}
