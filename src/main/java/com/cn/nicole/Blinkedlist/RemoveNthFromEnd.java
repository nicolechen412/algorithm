package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 10/25/22 10:33 PM
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        int n = 2;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = removeNthFromEnd(node1, 2);
        // ListNode head = removeNthFromEnd(node1, 1);
        ListUtil.printList(head);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 0 || head == null) {
            return head;
        }
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode p1 = tmpHead;
        ListNode p2 = tmpHead;

        int i = 0;
        while (p2.next != null) {
            p2 = p2.next;
            // i++;
            if (++i > n) {
                p1 = p1.next;
            }
        }

        p1.next = p1.next.next;


        return tmpHead.next;
    }

}
