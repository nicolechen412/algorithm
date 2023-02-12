package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/5/29 4:02 PM
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.entity.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * 合并k个有序链表
 */
public class MergeKList {

    public static void main(String[] args) {
        ListNode aHead = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        aHead.next = a2;
        a2.next = a3;

        ListNode bHead = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        bHead.next = b2;
        b2.next = b3;

        ListNode cHead = new ListNode(2);
        ListNode c2 = new ListNode(6);
        cHead.next = c2;

        ArrayList<ListNode> list = new ArrayList<>();
        list.add(aHead);
        list.add(bHead);
        list.add(cHead);
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = aHead;
        listNodes[1] = bHead;
        listNodes[2] = cHead;
        // ListNode head = mergeKList(list);
        ListNode head = mergeKList2(listNodes);
        while(head != null){
            System.out.println(head);
            head = head.next;
        }


    }

    private static ListNode mergeKList(ArrayList<ListNode> list) {

        if(list.isEmpty()){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>();

        for (ListNode node : list) {
            queue.insert(node);
        }

        //方法1 需要分开处理头结点
//        ListNode head = queue.getAndRemove();
//        if(head.next != null){
//            queue.insert(head.next);
//        }
//        ListNode result = null;
//        result = head;
//        while (queue.getSize() != 0) {
//            result.next = queue.getAndRemove();
//            ListNode tmp = result.next.next;
//            if(tmp != null){
//                queue.insert(tmp);
//            }
//            result = result.next;
//
//        }

        //优化 不处理头结点 直接返回头结点的next
        ListNode head = new ListNode(-1);
        ListNode result = head;

        while(queue.getSize() != 0){
            result.next = queue.getAndRemove();
            ListNode tmp = result.next.next;
            if(tmp != null){
                queue.insert(tmp);
            }
            result = result.next;
        }

        return head.next;


    }

    /**
     * 考虑其他分治算法 TODO
     * @param lists
     * @return
     */
    private static ListNode mergeKList2(ListNode[] lists) {

        if(lists == null){
            return null;
        }

        java.util.PriorityQueue<ListNode> pq = new java.util.PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for(int i = 0; i< lists.length ; i++){
            pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            if(p.next != null) {
                pq.add(p.next);
            }

        }

        return head.next;

    }

}

