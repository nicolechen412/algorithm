package com.cn.nicole.IDynamicProgramming;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 11/3/22 9:06 PM
 * desc  :
        斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

        F(0) = 0，F(1)= 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        给定n ，请计算 F(n) 。

        示例 3：
            输入：n = 4
            输出：3
            解释：F(4) = F(3) + F(2) = 2 + 1 = 3

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/fibonacci-number

 */

public class Fib {
    public static void main(String[] args) {
        // System.out.println(fib(4));
        System.out.println(fib2(4));
        System.out.println(fib3(4));
    }

    /**
     * 简单递归
     * 问题：这个算法带有重复计算，计算子问题数是二叉树中节点的总数，所以子问题数为2的n次，时间复杂度为O(2的n次)
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    /**
     * 带备忘录的递归解法
     * 问题：本题算法复杂度为O(n)，空间为O(n)
     * @param n
     * @return
     */
    public static int fib2(int n) {
        int[] memo = new int[n+1];

         return helper(memo, n);

    }

    private static int helper(int[] memo, int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = helper(memo, n-1) + helper(memo, n-2);
        return memo[n];
    }

    /**
     * 自底向上的迭代
     * 空间复杂度 常数次
     * @param n
     * @return
     */
    public static int fib3(int n) {
        int[] dp = new int[3];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];



    }

    private static int helper3(int[] memo, int n) {
        return 0;
    }

}
