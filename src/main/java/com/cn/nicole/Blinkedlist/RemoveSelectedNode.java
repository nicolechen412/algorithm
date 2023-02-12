package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/7/12 8:18 下午
 * desc  :
 */


import com.cn.nicole.entity.ListNode;

/**
 * 删除链表的中间节点 和 a/b处的节点
 *
 * 实现思路：
 *  1.删除中间节点，和O(1)获取链表的中间节点的方式一样，使用快慢指针，因为链表为双数时，取前面那一个，则快指针初始化时先走一步。
 *  2.删除a/b节点，一定要知道链表的长度，并且对a/b要乘以链表长度，向上取整。因此要遍历两遍。第二遍找到前置节点
 *  （double)(a/b) * (double) c）！= （double)(a*c) / (double) b）,因为（double)(a/b) == 0
 */
public class RemoveSelectedNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

//        ListNode newList = removeMidNode(head);
//        while(newList != null){
//            System.out.println(newList.getValue());
//            newList = newList.getNext();
//        }

        ListNode newList = removeByRatio(head, 3, 5);
        while(newList != null){
            System.out.println(newList.getValue());
            newList = newList.getNext();
        }
    }

    public static ListNode removeMidNode(ListNode head){

        if(head == null || head.getNext() == null){
            return head;
        }
        ListNode next  = head.getNext().getNext();
        ListNode cur = head;
        while(next.getNext() != null && next.getNext().getNext() != null){
            next = next.getNext().getNext();
            cur = cur.getNext();
        }

        cur.setNext(cur.getNext().getNext());
        return head;

    }

    public static ListNode removeByRatio(ListNode head, int a, int b){

        if(head == null || head.getNext() == null){
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while(cur.getNext() != null){
            cur = cur.getNext();
            len++;
        }

//        System.out.println(len);
        int n = (int) Math.ceil((double)(a * len) / (double)b);
//        System.out.println(n);
        System.out.println( "====" + (double)(a/b));
        cur = head;
        if(n == 1) return head.getNext();
        if( n > 1){
            while(--n != 1){
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
            return head;
        }

        return head;

    }
}
