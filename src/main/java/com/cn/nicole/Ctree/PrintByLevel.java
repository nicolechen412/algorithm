package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/22 10:13 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的按层答应和ZigZag打印
 *  1.按层打印。使用标记每一层的最后一个节点的方式。
 *      弹出队列中节点A，将该节点的左右子节点B/C放入队列中，比较弹出节点A是否为A这一层的最后一个节点，是则将右子节点C作为子节点这一层的最后一个节点。
 *  2.ZigZag打印。
 *      2.1. 简单方式：使用两个ArrayList，分别放两层节点，来回答应。缺点：ArrayList扩容时间复杂度O(N)，增加和删除节点的时间复杂度也比较高。
 *      2.2. 双端队列：和按层打印相似，记录上一层的最后一个节点。通过从头部入队和从尾部入队两个方式在一个队列中存放两层节点。
 *          如何区分两层节点？记录反方向入队的第一个节点。
 *          同时，由于每一层打印的方向是相反的，使用flag标记每一层的打印方向，换层时需要切换。
 */

public class PrintByLevel {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;

//        printByLevel(node1);
        printByZigZag(node1);

    }

    public static void printByLevel(TreeNode head) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode last = head;
        TreeNode curLast = null;
        int level = 1;
        queue.add(head);
        System.out.print("Level " + level++ + ": ");

        while (!queue.isEmpty()) {

            TreeNode cur = queue.pop();
            System.out.print(" " + cur.val);
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if (left != null) {
                queue.add(left);
                curLast = left;
            }
            if (right != null) {
                queue.add(right);
                curLast = right;
            }

            if (cur == last && !queue.isEmpty()) {
                //设置这一层的最后一个节点标记
                last = curLast;
                System.out.println();
                //打印下一层的层级
                System.out.print("Level " + level++ + ": ");
            }

        }
    }

    public static void printByZigZag(TreeNode head) {
        if (head == null) {
            return;
        }

        TreeNode last = head;
        TreeNode nlast = null;
        boolean isOrader = true;
        int level = 1;
        TreeNode left = null;
        TreeNode right = null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(head);
        printLevelAndOrientation(level++, isOrader);

        while (!queue.isEmpty()) {
            if (isOrader) {
                head = queue.pollFirst();
                if(head.left != null){
                    left = head.left;
                    queue.offerLast(left);
                    nlast = nlast == null ? left : nlast;
                }

                if(head.right != null){
                    right = head.right;
                    queue.offerLast(right);
                    nlast = nlast == null ? right : nlast;
                }

            } else {
                head = queue.pollLast();
                if(head.right != null){
                    right = head.right;
                    queue.offerFirst(right);
                    nlast = nlast == null ? right : nlast;
                }
                if(head.left != null){
                    left = head.left;
                    queue.offerFirst(left);
                    nlast = nlast == null ? left : nlast;
                }
            }
            System.out.print(head.val + " ");
            if(head == last && !queue.isEmpty()){
                isOrader = !isOrader;
                last = nlast;
                nlast = null;
                printLevelAndOrientation(level ++, isOrader);
            }


        }


    }

    public static void printLevelAndOrientation(int level, boolean ir) {
        System.out.println();
        System.out.print("Level " + level + " from ");
        if (ir) {
            System.out.print("left to right: ");
        } else {
            System.out.print("right to left: ");
        }


    }

}
