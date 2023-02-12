package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/21 10:57 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;

/**
 * 找到二叉树中的最大搜索二叉树
 *
 * 解法：动态规划，使用后序遍历的方式，
 *      判断一棵搜索二叉树：
 *      判断左子树的头结点是否等于当前节点的左孩子节点，右子树同理，
 *      判断左子树的最大值小于当前节点值，右子树的最小值大于当前节点值
 *
 *      更新当前搜索二叉树的头结点，节点数量，最小值和最大值。
 *
 *      返回当前搜索二叉树的头结点
 */

public class BiggerSubBST {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(13);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(14);
        TreeNode node10 = new TreeNode(20);
        TreeNode node11 = new TreeNode(16);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(5);
        TreeNode node14 = new TreeNode(11);
        TreeNode node15 = new TreeNode(15);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node6.left = node8;
        node6.right = node9;
        node7.left = node10;
        node7.right = node11;
        node8.left = node12;
        node8.right = node13;
        node9.left = node14;
        node9.right = node15;

        System.out.println(biggerSubBST(node1).val);


    }

    public static TreeNode biggerSubBST(TreeNode head){
        int[] arr = new int[3];
        TreeNode node = postOrder(head, arr);
        return node;
    }

    public static TreeNode postOrder(TreeNode head, int[] arr){
        if(head == null){
            arr[0] = 0;
            arr[1] = Integer.MIN_VALUE;
            arr[2] = Integer.MAX_VALUE;
            return null;
        }
        int value = head.val;
        TreeNode left = head.left;
        TreeNode right = head.right;

        TreeNode leftHead = postOrder(head.left, arr);
        int lsize = arr[0];
        int lmin = arr[1];
        int lmax = arr[2];

        TreeNode rightHead = postOrder(head.right, arr);
        int rsize = arr[0];
        int rmin = arr[1];
        int rmax = arr[2];

        arr[1] = Math.max(lmin, value);//只有接下来的判断满足搜索二叉树才有用，如果不是搜索二叉树，不会继续使用
        arr[2] = Math.max(rmax, value);//所以只需要考虑满足搜索二叉树的情况

        if(leftHead == left && rightHead == right&& value > lmin && value < rmax){
            arr[0] =  lsize + rsize + 1;
            return head;
        }
        arr[0] = Math.max(lsize, rsize);
        return lsize > rsize ? leftHead : rightHead;
    }


}
