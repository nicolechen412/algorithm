package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/26 5:15 下午
 * desc  :
 */

/**
 * 将搜索二叉树转换成双向链表
 * 方法一：就是考查中序遍历二叉树，将遍历结果放入到队列中，然后取出组成双向链表。时间复杂度O(N),额外空间复杂度O(N)
 *
 */

import com.cn.nicole.entity.TreeNode;

import java.util.LinkedList;

public class Convert {

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

        node6.setLeftChild(node4);
        node6.setRightChild(node7);
        node4.setLeftChild(node2);
        node4.setRightChild(node5);
        node2.setLeftChild(node1);
        node2.setRightChild(node3);
        node7.setRightChild(node9);
        node9.setLeftChild(node8);

        TreeNode head = convert(node6);
        while(head != null){
            System.out.print("node: " + head.val );
            if(head.getLeftChild()!=null){
                System.out.print(", last: " + head.getLeftChild().val);
            }
            if(head.getRightChild()!=null){
                System.out.print(", next: " + head.getRightChild().val);
            }
            System.out.println();
            head = head.getRightChild();
        }

    }

    public static TreeNode convert(TreeNode head){
        LinkedList<TreeNode> list = new LinkedList();
        inOrderToQueue(head, list);
        TreeNode pre = null;
        TreeNode cur = null;
        while(!list.isEmpty()){
           cur = list.poll();
            if(pre == null){
                pre = cur;
                head = pre;
            } else {
                pre.setRightChild(cur);
                cur.setLeftChild(pre);
                pre = cur;
            }

        }

        return head;

    }

    private static void inOrderToQueue(TreeNode head, LinkedList list) {

        if(head == null){
            return;
        }
        inOrderToQueue(head.getLeftChild(), list);
        list.offer(head);
        inOrderToQueue(head.getRightChild(), list);
    }

}
