package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/9/13 12:51 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

/**
 * 在单链表中将from到to的这一部分反转
 *
 * 实现思路：
 *      因为是反转部分连续节点，这里分两步。
 *      1.不需要反转的部分，在反转部分的头之前和尾之后确定两个节点pre和post；
 *      2.需要反转的部分，和单链表反转一样，需要tmp、head和next三个节点
 *
 *      所以该算法需要至少5个节点，无法减少。开始反转时，反转后的尾结点要连post，结束反转时，pre要连反转后的头结点。
 */
public class ReversePartList {


    public static ListNode reversePartList(ListNode head, int from, int to){
        if (to <= 1){
            return head;
        }

        ListNode tmp = head;
        int length = 0;

        ListNode pre = null;
        ListNode post = null;
        while(tmp != null){
            length++;
            if(length + 1 == from){
                pre = tmp;
            }
            if(to + 1 == length){
                post = tmp;
                break;
            }
            tmp = tmp.next;
        }

        if(from > length || from > to){
            return head;
        }

        ListNode node1 = pre==null ? head : pre.next;
        ListNode node2 = node1.next;
        ListNode next = null;
        node1.next = post;
        while(node2 != post){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if(pre != null){
            pre.next = node1;
            return head;
        }

        return node1;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.initializeList();
        ListUtil.printList(head);

        int from = 4;
        int to = 2;
        ListNode newHead = reversePartList(head, from, to);

        ListUtil.printList(newHead);

    }

}
