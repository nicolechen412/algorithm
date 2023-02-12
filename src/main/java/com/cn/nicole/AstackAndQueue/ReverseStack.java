package com.cn.nicole.AstackAndQueue;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/4/24 5:06 下午
 * desc  :
 */

import java.util.Stack;

/**
 * 03.用栈和递归实现栈的逆序
 *
 * 实现思路，共两个递归函数：
 *  1.栈要逆序，就要把第一个入栈的数拿到，然后最后入栈。所以获取第一个入栈的数并从栈移除用递归实现
 *  2.实现逆序。用递归实现
 *
 *
 * 递归要注意：先判断终止条件，再调用递归。
 * 思考时，在假定该递归已实现的基础上推导思路是否正确，不要钻到死胡同。最好拿递归的倒数第二次做判断。
 */
public class ReverseStack {

    public static void main(String[] args) {

    }

}
class MyStack2{

    private Stack<Integer> stack = new Stack<>();

    void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int last = getLastAndRemove(stack);
        reverse(stack);
        stack.push(last);

    }

    int getLastAndRemove(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }
        int last =  getLastAndRemove(stack);
        stack.push(result);
        return last;
    }

}
