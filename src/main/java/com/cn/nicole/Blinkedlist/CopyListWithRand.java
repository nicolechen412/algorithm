package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/13 10:39 下午
 * desc  :
 */

import com.cn.nicole.entity.RandNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  复制含有随机节点指针节点的链表
 *
 *  解法:
 *  1. 使用Map，时间复杂度O(N),额外空间复杂度O(N)。
 *      key为原始链表节点，value为新增链表的节点。则Map建立完成后，原始链表的rand节点与新链表的rand节点的关系已经建立，完善新链表节点的next和rand关系就好
 *      key: O -> value: N
 *  2. 使用链表，时间复杂度O(N),额外空间复杂度O(1)
 *      将新旧链表穿插建立链表（O->N->O->N），建立完后，新旧链表的rand节点关系建立，先完善新链表节点的rand关系就好。然后将新链表从混合链表中剥离出来。
 */

public class CopyListWithRand {

    public static void main(String[] args) {

        RandNode randNode1 = new RandNode(1);
        RandNode randNode2 = new RandNode(2);
        RandNode randNode3 = new RandNode(3);
        RandNode randNode4 = new RandNode(4);
        RandNode randNode5 = new RandNode(5);

        randNode1.next = randNode2;
        randNode2.next = randNode3;
        randNode3.next = randNode4;
        randNode4.next = randNode5;

        randNode1.rand = randNode4;
        randNode2.rand = randNode1;
        randNode3.rand = randNode5;
        randNode4.rand = randNode2;
        randNode5.rand = randNode2;

        RandNode newNode = copyListWithRand2(randNode1);
//        RandNode newNode = copyListWithRand(randNode1);

        while(newNode != null){
            System.out.println("value: "+ newNode.val + " rand: " + newNode.rand.val);
            newNode = newNode.next;
        }


    }

    public static RandNode copyListWithRand(RandNode head){
        HashMap<RandNode, RandNode> map = new HashMap<>();
        RandNode tmp = head;
        //node
        while(tmp != null){
            RandNode n1 = new RandNode(tmp.val);
            map.put(tmp, n1);
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp != null){
            RandNode node = map.get(tmp);
            RandNode next = map.get(tmp.next);
            node.next = next;
            tmp = tmp.next;
        }
        tmp = head;
        //rand
        for(Map.Entry<RandNode, RandNode> entry : map.entrySet()){
            RandNode oldNode = entry.getKey();
            RandNode node = entry.getValue();
            RandNode rand = map.get(oldNode.rand);
            node.rand = rand;
        }

        return map.get(tmp);

    }

    public static RandNode copyListWithRand2(RandNode head){

        RandNode tmp = head;

        //将新旧链表连在一起
        while(tmp.next != null){
            RandNode newNode = new RandNode(tmp.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = tmp.next.next;
        }
        RandNode newNode = new RandNode(tmp.val);
        tmp.next = newNode;

        //创建rand连接
        tmp = head;
        while(tmp != null){
            newNode = tmp.next;
            newNode.rand = tmp.rand.next;
            if(tmp.next.next != null){
                tmp = tmp.next.next;
            } else {
                break;
            }
        }

        //拆分链表
        RandNode newHead = head.next;
        tmp = head.next;
        while(tmp.next != null){
            tmp.next = tmp.next.next;
            if(tmp.next.next != null){
                tmp = tmp.next;
            } else {
                break;
            }

        }
        return newHead;


    }



}
