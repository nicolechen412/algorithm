package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/7/19 9:13 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;

/**
 * 反转单向链表和双向链表
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.setNext(node2);
        node2.setNext(node3);

        head = reverseList(head);
        while(head != null){
            System.out.println(head.getValue());
            head = head.getNext();
        }


    }

    public static ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode next = null;

        while(head != null){
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode doubleReverseList(DoubleNode head){

        DoubleNode pre = null;
        DoubleNode next = null;

        while(head != null){
            next = head.getNext();
            head.setNext(pre);
            head.setPrev(next);
            pre = head;
            head = next;
        }
        return pre;
    }

}
