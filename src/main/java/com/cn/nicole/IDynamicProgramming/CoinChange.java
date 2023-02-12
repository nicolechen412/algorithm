package com.cn.nicole.IDynamicProgramming;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 11/3/22 10:09 PM
 * desc  :
        给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。你可以认为每种硬币的数量是无限的。

        示例 1：
            输入：coins = [1, 2, 5], amount = 11
            输出：3
            解释：11 = 5 + 5 + 1

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/coin-change

 */

import java.util.Arrays;

public class CoinChange {

    static int[] memo;

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        memo = new int[amount+1];
        Arrays.fill(memo, -1);
        System.out.println(coinChange(coins, amount));


    }
    public static int coinChange(int[] coins, int amount) {

        // return dp(coins, amount);
        return dp2(coins, amount);
    }

    private static int dp(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i< coins.length; i++){
            int subProblem = dp(coins, amount - coins[i]);
            if(subProblem < 0){
                continue;
            }

            result =  Math.min(result, subProblem+1);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 带备忘录的动态规划
     * @param coins
     * @param amount
     * @return
     */
    private static int dp2(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(memo[amount] != -1){
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i< coins.length; i++){
            int subProblem = dp(coins, amount - coins[i]);
            if(subProblem < 0){
                continue;
            }

            result =  Math.min(result, subProblem+1);
            // memo[amount] = result;
        }
        return memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 迭代解法
     * @param coins
     * @param amount
     * @return
     */
    private static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 0; i < dp.length; i++){
            for(int coin : coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        //如果等于初始化值，则返回-1
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }


}
