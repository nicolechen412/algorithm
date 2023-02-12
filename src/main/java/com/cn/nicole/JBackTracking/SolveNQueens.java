package com.cn.nicole.JBackTracking;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 11/6/22 5:37 PM
 * desc  :
        按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。n皇后问题 研究的是如何将 n个皇后放置在 n×n
        棋盘上，并且使皇后彼此之间不能相互攻击。给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
        每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
        示例 1：

        输入：n = 4
        输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        解释：如上图所示，4 皇后问题存在两个不同的解法。


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/n-queens

 */

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {

    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        solveNQueens(5);
        System.out.println(result);
    }

    public static List<List<String>> solveNQueens(int n) {

        List<StringBuilder> board = new ArrayList<>();
        for(int i = 0 ; i<n ;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j<n ;j++){
                sb.append(".");
            }
            board.add(sb);

        }
        backtrack(board, n,0);
        return result;
    }

    private static void backtrack(List<StringBuilder> board, int n, int row) {
        if(board.size() == row){
            List<String> strings = new ArrayList<>();
            for(StringBuilder sb : board){
                String s = sb.toString();
                strings.add(s);
            }
            result.add(strings);
            return;
        }
        int col = 0;
        for(int i = 0; i < n; i++){
            col = i;
            if(!isValid(board,row,col)){
                continue;
            }
            StringBuilder sb  = board.get(row);
            sb.replace(col, col+1, "Q");
            backtrack(board, n, row+1);
            sb.replace(col, col+1, ".");
        }

    }

    private static boolean isValid(List<StringBuilder> board,int row, int col) {
        for(int i = row-1; i >=0; i--){
            if(board.get(i).substring(col, col+1).equals("Q")){
                return false;
            }
        }

        for(int i = row-1, j = col-1; i >= 0 && j>=0; i--, j--){
            if(board.get(i).substring(j, j+1).equals("Q")){
                return false;
            }
        }

        for(int i = row-1, j = col+1; i >= 0 && j<board.size(); i--, j++){
            if(board.get(i).substring(j, j+1).equals("Q")){
                return false;
            }
        }
        return true;
    }


}
