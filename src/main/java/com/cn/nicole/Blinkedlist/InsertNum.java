package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/26 10:27 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;


/**
 * 向有序的环形链表中插入新节点
 *
 *      思路简单，但是需要考虑多种情况：
 *          1.节点为null。
 *          2.插入的节点比头结点小
 *          3.插入的节点比尾节点打
 *          4.前一个节点比插入的节点小，后一个节点比插入的节点大
 */
public class InsertNum {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
//        node1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        ListNode head = insertNum(3, node1);
        ListNode tmp = head;
        System.out.println(tmp.val);
        tmp = tmp != null ? tmp.next: head;
        while(!tmp.equals(head)){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }


    }

    public static ListNode insertNum(int num, ListNode head){
        ListNode cur = head;
        ListNode post = head.next;
        if(cur == null){
            ListNode newHead = new ListNode(num);
            return newHead;
        }
        if(cur.val > num){
            ListNode newHead = new ListNode(num);
            newHead.next = cur;
            while(!cur.next.equals(head)){
                cur = cur.next;
            }
            cur.next = newHead;
            return newHead;
        }

        cur = head.next;
        if(cur != head){
            post = cur.next;
        } else {
            ListNode newHead = new ListNode(num);
            newHead.next = head.next;
            head.next = newHead;
            return head;
        }

        while(!cur.equals(head)){
            if(cur.val <= num && cur.next.val >= num){
                ListNode newNode = new ListNode(num);
                newNode.next = post;
                cur.next = newNode;
                return head;
            } else {

                if(cur.val < num && cur.next.equals(head)){
                    ListNode newNode = new ListNode(num);
                    newNode.next = head;
                    cur.next = newNode;
                    return head;
                }

            }
            cur = cur.next;
            post = cur.next;
        }
        return head;

    }

}
