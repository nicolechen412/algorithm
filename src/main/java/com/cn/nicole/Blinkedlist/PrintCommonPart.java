package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/7/1 7:42 上午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;

/**
 * 给定两个有序链表的头指针，打印两个链表的公共部分。
 *
 * 实现思路：
 *      因为是有序的，只要比较大小，小的向后移动就可以；因为是公共部分，只要相等就打印，不需要判断连续。
 */
public class PrintCommonPart {


    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        ListNode node14 = new ListNode(6);
        ListNode node15 = new ListNode(9);

        head1.setNext(node12);
        node12.setNext(node13);
        node13.setNext(node14);
        node14.setNext(node15);

        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(4);
        ListNode node24 = new ListNode(6);
        ListNode node25 = new ListNode(9);

        head2.setNext(node22);
        node22.setNext(node23);
        node23.setNext(node24);
        node24.setNext(node25);

        printCommonPart(head1,head2);
    }

    public static void printCommonPart(ListNode head1, ListNode head2){

        ListNode tmp1 = head1;
        ListNode tmp2 = head2;



        while(tmp1!= null && tmp2!= null){
            if(tmp1.getValue() == tmp2.getValue()){
                System.out.println(tmp1.getValue());
                tmp1 = tmp1.getNext();
                tmp2 = tmp2.getNext();
            } else if(tmp1.getValue() > tmp2.getValue()){
                tmp2 = tmp2.getNext();
            } else {
                tmp1 = tmp1.getNext();
            }

        }

    }




}




