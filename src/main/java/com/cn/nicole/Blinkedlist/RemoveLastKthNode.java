package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/7/4 2:07 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;

/**
 * 移除单链表和双链表中倒数第k个元素，时间复杂度O(N)，额外空间复杂度O(1)
 *
 * 实现思路：
 *  1.因为是倒数，先遍历一遍链表，每遍历一个，k=k-1，则当k=0的时候，是可以确认是需要删除的元素。然后将链表遍历完成。
 *  2.使用k，重新遍历链表，每遍历一个元素+1，则当k=0时，为需要删除元素的前置节点，修改该节点的指针方向就可以了。
 *
 */
public class RemoveLastKthNode {


    public static void main(String[] args) {

//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//
//        head.setNext(node2);
//        node2.setNext(node3);
//        node3.setNext(node4);
//        node4.setNext(node5);
//
//        int k = 3;
//
//        ListNode newList = removeLastKthNode(head, k);
//        while(newList != null){
//            System.out.println(newList.getValue());
//            newList = newList.getNext();
//        }

        DoubleNode head2 = new DoubleNode(5);
        DoubleNode node6 = new DoubleNode(6);
        DoubleNode node7 = new DoubleNode(7);
        DoubleNode node8 = new DoubleNode(8);
        DoubleNode node9 = new DoubleNode(9);

        head2.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);


        node6.setPrev(head2);
        node7.setPrev(node6);
        node8.setPrev(node7);
        node9.setPrev(node8);

        int k = 5;

        DoubleNode newList2 = removeLastKthDoubleNode(head2, k);



        System.out.println(newList2.getValue());
        while(newList2.getNext() != null){
            System.out.println(newList2.getNext().getValue());
            newList2 = newList2.getNext();
        }

        System.out.println();

        while(newList2 != null){
            System.out.println(newList2.getValue());
            newList2 = newList2.getPrev();
        }

    }

    private static ListNode removeLastKthNode(ListNode head, int k) {

        if(head == null || k < 1){
            return head;
        }
        ListNode tmp = head;
        int n = k-1;
        while(tmp.getNext() != null){
            tmp = tmp.getNext();
            n = n-1;
        }
        if(n == 0){
            return head.getNext();
        }
        if(n > 0){
            return head;
        }
        tmp = head;
        while(++n != 0){
            tmp = tmp.getNext();
        }
        tmp.setNext(tmp.getNext().getNext());
        return head;

    }

    private static DoubleNode removeLastKthDoubleNode(DoubleNode head, int k) {

        if(head == null || k < 1){
            return head;
        }
        DoubleNode tmp = head;
        int n = k-1;
        while(tmp.getNext() != null){
            tmp = tmp.getNext();
            n = n-1;
        }
        if(n == 0){
            head =  head.getNext();
            head.setPrev(null);
            return head;
        }
        if(n > 0){
            return head;
        }
        tmp = head;
        while(++n != 0){
            tmp = tmp.getNext();
        }
        tmp.setNext(tmp.getNext().getNext());
        tmp.getNext().setPrev(tmp);
        return head;

    }


}

class DoubleNode{

    private int val;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int value) {
        this.val = value;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}


