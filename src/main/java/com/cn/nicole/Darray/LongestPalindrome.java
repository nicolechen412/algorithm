package com.cn.nicole.Darray;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 10/30/22 8:48 PM
 * desc  :
        给你一个字符串 s，找到 s 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

        示例 1：
        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。

        示例 2：
        输入：s = "cbbd"
        输出："bb"

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-palindromic-substring
 */

public class LongestPalindrome {

    public static void main(String[] args) {
        // String s = "babad";
        // String s = "bab";
        // String s = "b";
        String s = "";
        String res = longestPalindrome(s);
    }

    public static String longestPalindrome(String s) {
        if(s == ""){
            return "";
        }
        String res = "";
        String s1 = "";
        String s2 = "";
        for(int i = 0; i < s.length(); i++){
            s1 = palindrome(s, i, i);
            s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private static String palindrome(String s, int l, int r) {
        while(l >= 0 && r <= s.length()-1){
            if(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            } else {
                break;
            }
        }
        return s.substring(l+1,r);
    }

}
