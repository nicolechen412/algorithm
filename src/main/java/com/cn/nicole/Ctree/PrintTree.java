package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/4 7:40 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;

/**
 * 使用常规的三种遍历方式，直观的打印二叉树，二叉树节点值类型为32位整型
 *
 *  解决：
 *      控制二叉树打印的宽度：选择向左旋转90°二叉树打印
 *      已知节点值类型，通过使用空格控制好每层节点所在位置
 *      先右子树，然后根节点，最后左子树的顺序打印
 */

public class PrintTree {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.right = node7;

        printTree(node1);

    }

    public static void printTree(TreeNode node){

        if(node == null){
            return;
        }
        printInOrder(node, 0, "H", 17);

    }

    private static void printInOrder(TreeNode node, int height, String to, int len) {
        if(node == null){
            return;
        }
        printInOrder(node.right, height + 1, "v", len);
        String str = to + node.val + to;

        int strLen = str.length();
        int lenL = (len - strLen)/2;
        int lenR = (len - strLen) - lenL;

        str = getSpace(lenL) + str + getSpace(lenR);

        System.out.println(getSpace(height*len)  + str);
        printInOrder(node.left, height + 1, "^", len);

    }

    public static String getSpace(int len){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append(" ");
        }

        return sb.toString();
    }

}
