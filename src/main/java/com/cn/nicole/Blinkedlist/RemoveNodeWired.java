package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/26 9:58 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

/**
 * 一种怪异的删除节点方式。没有头结点，只有需要删除的给定节点
 *  问题： 无法删除节点的最后一个节点，因为无法找到前置节点，将该节点的next设为空。
 *          本质上是修改了节点的值和next指针，在实际工程中数据结构很复杂，有很大问题。
 */
public class RemoveNodeWired {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        removeNodeWired(node2);
        ListUtil.printList(node1);

    }

    public static void removeNodeWired(ListNode node){
        if(node == null){
            return;
        }
        if(node.next == null){
            throw new RuntimeException("can not remove last node");
        }
        node.val = node.next.val;
        node.next = node.next.next;


    }

}
