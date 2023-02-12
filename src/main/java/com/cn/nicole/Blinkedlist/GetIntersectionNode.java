package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 10/27/22 10:05 PM
 * desc  : 找出两个单链表的交叉节点。关键点在于两条链表长度不一样，为了保证同时找到交叉节点，则需要将A/B两条链表变成A+B和B+A，或者先遍历两条链表获取链表长度，然后
 *          长链表先执行，直到两条链表遍历长度相同。
 */

import com.cn.nicole.entity.ListNode;

public class GetIntersectionNode {

    public static void main(String[] args) {
        // ListNode node1 = new ListNode(4);
        // ListNode node2 = new ListNode(1);
        // ListNode node3 = new ListNode(8);
        // ListNode node4 = new ListNode(4);
        // ListNode node5 = new ListNode(5);
        // ListNode node6 = new ListNode(5);
        // ListNode node7 = new ListNode(6);
        // ListNode node8 = new ListNode(1);
        //
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        //
        // node6.next = node7;
        // node7.next = node8;
        // node8.next = node3;

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(5);




        node1.next = node2;
        node2.next = node3;

        node4.next = node5;



        ListNode result = getIntersectionNode(node1, node4);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null || p2 != null){
            if(p1 == null){
                p1 = headB;
            }
            if(p2 == null){
                p2 = headA;
            }
            if(p1 == p2){
                return p1;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return null;

    }

}
