package com.cn.nicole.AstackAndQueue;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/4/23 1:24 下午
 * desc  :
 */

import java.util.Stack;

/**
 * 01.实现push/pop/getMin 都是O(1)的栈
 */
public class StackGetMin {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(2);
        System.out.println(myStack.getMin());
        myStack.push(1);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();
        myStack.getMin();
    }



}

 class MyStack{



    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> minStack = new Stack();

    public int pop(){
        int result;
        if(!stack1.isEmpty()){
            result = stack1.pop();
            if(!minStack.isEmpty()){
                if(result == minStack.peek()){
                    minStack.pop();
                }
            } else {
                throw new RuntimeException("stack is null");
            }
        } else {
            throw new RuntimeException("stack is null");
        }

        return result;

    }

    public void push(int value){
        int result = stack1.push(value);
        if(!minStack.isEmpty()){
            if(result <= minStack.peek()){
                minStack.push(value);
            }
        } else {
            minStack.push(value);

        }


    }

    public int getMin(){
        if(minStack != null){
            return minStack.peek();
        } else {
            throw new RuntimeException("stack is null");
        }
    }
}
