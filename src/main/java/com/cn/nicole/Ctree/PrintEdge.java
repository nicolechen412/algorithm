package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/4 3:42 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;

/**
 * 打印二叉树的边界节点（只实现了标准一）
 *  标准一：
 *      1.头结点为边界节点
 *      2.叶节点为边界节点
 *      3.树左边界延伸下去的为边界节点
 *      4.树右边界延伸下去的为边界节点
 *
 *      例如：如下树打印结果为： 1， 2，4，7，11，13，14，15，16，12，10，6，3
 *
 *                              1
 *                          /       \
 *                       2             3
 *                       \           /    \
 *                       4          5      6
 *                     /  \        /  \
 *                    7   8       9   10
 *                        \      /
 *                       11     12
 *                     /  \     /  \
 *                   13   14   15  16
 */

public class PrintEdge {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        TreeNode node16 = new TreeNode(16);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.left = node9;
        node5.right = node10;
        node8.right = node11;
        node9.left = node12;
        node11.left = node13;
        node11.right = node14;
        node12.left = node15;
        node12.right = node16;

        printEdge(node1);


    }

    public static void printEdge(TreeNode head){

        if(head == null){
            return;
        }
        int h = getHeight(head, 0);

        TreeNode[][] edge = new TreeNode[h][2];

        setEdgeArr(head, 0, edge);

        //打印左边界
        for(int i = 0; i < h; i++){
            System.out.println(edge[i][0].val);
        }
        //打印非边界叶子节点
        printLeafNotInMap(head, 0, edge);
        //逆序打印右边界
        for(int i = h-1; i >= 0 ; --i){
            System.out.println(edge[i][1].val);
        }

    }

    public static int getHeight(TreeNode node, int n){
        if(node == null){
            return n;
        }

        return Math.max(getHeight(node.left, n+1), getHeight(node.right, n+1));
    }

    /**
     * 安装深度遍历，每次左边界都会覆盖，需要保留第一次赋值，所以需要判断；右边界只保留最后一次赋值就好了，所以可以一直覆盖
     * @param node
     * @param n
     * @param edge
     */
    public static void setEdgeArr(TreeNode node, int n,  TreeNode[][] edge){
        if(node == null){
            return;
        }
        //左边界节点
        edge[n][0] = edge[n][0] == null ? node : edge[n][0];

        //右边界节点
        edge[n][1] = node;

        setEdgeArr(node.left, n+1, edge);
        setEdgeArr(node.right, n+1, edge);
    }


    public static void printLeafNotInMap(TreeNode node, int n, TreeNode[][] nodes){

        if(node == null){
            return;
        }

        if(node.left == null && node.right == null && node != nodes[n][0] && node != nodes[n][1]){
            System.out.println(node.val);
        }

        printLeafNotInMap(node.left, n+1, nodes);
        printLeafNotInMap(node.right, n+1, nodes);


    }

}
