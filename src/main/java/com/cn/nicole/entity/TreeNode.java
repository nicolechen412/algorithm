package com.cn.nicole.entity;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/20 1:22 下午
 * desc  :
 */

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;


    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode( int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode getLeftChild() {
        return left;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.left = leftChild;
    }

    public TreeNode getRightChild() {
        return right;
    }

    public void setRightChild(TreeNode rightChild) {
        this.right = rightChild;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }
}
