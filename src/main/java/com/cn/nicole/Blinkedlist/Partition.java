package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 10/24/22 9:35 PM
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

/**
 * 分割链表
 * 反过来同合并链表，建立两个虚拟头节点
 */
public class Partition {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;


        ListNode head = partition(node1, 3);
        ListUtil.printList(head);


    }

    public static ListNode partition(ListNode head, int i){
        ListNode left = new ListNode(-1);
        ListNode p1 = left;
        ListNode right = new ListNode(-1);
        ListNode p2 = right;
        ListNode p = head;
        while(p != null){
            if(p.val < i){
                left.next = p;
                left = left.next;
            } else {
                right.next = p;
                right = right.next;
            }
            p = p.next;
        }
        right.next = null;
        left.next = p2.next;

        return p1.next;
    }


}
