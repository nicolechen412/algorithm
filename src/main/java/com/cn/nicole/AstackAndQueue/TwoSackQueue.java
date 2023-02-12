package com.cn.nicole.AstackAndQueue;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/4/24 4:23 下午
 * desc  :
 */

import java.util.Stack;

/**
 * 02.用栈实现队列
 */
public class TwoSackQueue {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        queue.add(6);
        queue.add(5);
        queue.add(4);
        System.out.println(queue.poll());

        System.out.println(queue.peek());

        System.out.println(queue.poll());


    }

}

class MyQueue{

    private Stack<Integer> firstStack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();

    public void add(int value){
        firstStack.add(value);
    }

    public int poll(){
        if(secondStack.isEmpty() && firstStack.isEmpty()){
            throw new RuntimeException("stack is null");
        }
        if(secondStack.isEmpty()){
            while(!firstStack.isEmpty()){
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    public int peek(){
        if(secondStack.isEmpty() && firstStack.isEmpty()){
            throw new RuntimeException("stack is null");
        }
        if(secondStack.isEmpty()){
            while(!firstStack.isEmpty()){
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
    }
}
