package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/27 9:50 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

/**
 * 按左右半区的方式重新组合单链表
 *
 */
public class MergeLR {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode mid = relocate(node1);
        ListNode head = mergeLR(node1, mid);
        ListUtil.printList(head);

    }

    //找到右链表的第一个节点，并把左链表的最后一个节点的指针置为空
    public static ListNode relocate(ListNode node1){

        if(node1 ==  null){
            return null;
        }
        if(node1.next == null){
            return node1;
        }

        ListNode mid = node1;
        ListNode right = node1.next;
        while(right.next != null && right.next.next!= null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        return right;
    }


    public static ListNode mergeLR(ListNode left, ListNode right){
        ListNode next= null;
        ListNode newHead  = left;
        while(left.next != null){
          next =  right.next;
          right.next = left.next;
          left.next = right;
          left = right.next;
          right = next;
        }
        left.next = right;
        return newHead;
    }


}
