package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/19 2:27 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

import java.util.HashSet;

/**
 * 删除无序链表中值重复的节点
 *
 *  方法一：时间复杂度 O(N)。使用Hashset，每遍历一个节点，与Hashset中节点比较，存在则去除重复节点，不存在加入到Hashset中。
 *  方法二：额外空间复杂度O(1)。遍历链表，每遍历到一个节点，则将该节点的value与链表的其他节点比较，重复则移除后面的节点。
 */

public class RemoveRep {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode node = removeRep(node1);
        ListUtil.printList(node);


    }

    /**
     * 方法一
     * @param head
     * @return
     */
    public static ListNode removeRep(ListNode head){

        HashSet set = new HashSet<Integer>();
        ListNode tmp = head;
        ListNode pre = head;
        while(tmp != null){
            if(set.contains(tmp.val)){
                pre.next = tmp.next;
                tmp = tmp.next;

            } else {
                set.add(tmp.val);
                pre = tmp;
                tmp = tmp.next;
            }


        }
        return head;
    }

}
