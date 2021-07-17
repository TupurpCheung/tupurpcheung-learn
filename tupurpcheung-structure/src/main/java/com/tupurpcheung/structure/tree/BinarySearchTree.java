package com.tupurpcheung.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title BinarySearchTree
 * @package tree
 * @description 二分搜索树定义：
 * 1：二分搜索树是二叉树
 * 2：二分搜索树，每个节点的值都大于其左子树全部节点的值，每个节点的值都小于其右子树全部节点的值
 * 3：节点的左右子树也为二分搜索树
 * 4：存储的元素必须有可比较性
 * @date 2018/11/16 14:53
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }


    public boolean contains(E e) {
        return contains(root, e);
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

    /**二分搜索树的层序遍历*/
    public void levelOrder(){
        Queue<Node> quere = new LinkedList<>();
        quere.add(root);
        while(!quere.isEmpty()){
            Node cur = quere.remove();
            System.out.println(cur.e);
            if(cur.left != null){
                quere.add(cur.left);
            }
            if(cur.right != null){
                quere.add(cur.right);
            }
        }
    }


    /**寻找二分搜索树的最小元素*/
    public E  minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }


    public void remove(E e){

    root = remove(root,e);

    }

    private Node  remove(Node node,E e){

        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
           node.left =   remove(node.left,e);
           return node;
        }else if(e.compareTo(node.e) > 0){
           node.right =  remove(node.right,e);
           return node;
        }else{

            /**待删除节点左子树为空*/
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            /**待删除节点右子树为空*/
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
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

    /**从二分搜索树中删除最小值所在节点，并返回最小值*/
    public E removeMin(){
       E ret = minimum();
       root = removeMin(root);
       return ret;
    }

    public Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);

        return node;
    }


    /**寻找二分搜索树的最大元素*/
    public E  maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 使用递归向以Node未根的二分搜索树中插入元素e
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;

    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;

        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);

        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 以Node为根的二分搜索树的前序遍历
     */
    private void preOrder(Node node) {

        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);


    }
    /**
     * 以Node为根的二分搜索树的中序遍历
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 以Node为根的二分搜索树的后序遍历
     */
    private void postOrder(Node node){
        if(node == null){
            return;
        }


        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    @Override
    public  String toString(){
        StringBuilder res = new StringBuilder();

        generateBSTString(root,0,res);

        return res.toString();
    }
   private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)+ "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<depth; i++){
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num:nums){
            bst.add(num);
        }

        bst.preOrder();

        System.out.println();
        bst.inOrder();

        System.out.println();
        System.out.println(bst);


    }


}
