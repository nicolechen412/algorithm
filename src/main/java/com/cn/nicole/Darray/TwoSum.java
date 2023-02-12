package com.cn.nicole.Darray;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 10/29/22 11:59 PM
 * desc  :

        给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
        以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
        你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
        你所设计的解决方案必须只使用常量级的额外空间。

        示例 1：

        输入：numbers = [2,7,11,15], target = 9
        输出：[1,2]
        解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 */

public class TwoSum {


    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum2(numbers, target);
    }

    /**
     * 轮询遍历
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = 1;
        int[] result = new int[2];
        while(p2 <= numbers.length-1 && p1 <= numbers.length-2){
            if(numbers[p1] + numbers[p2] == target ){
                result[0] = p1+1;
                result[1] = p2+1;
                return result;
            } else if(p2 == numbers.length-1 && p1 != p2-1){
                p1 = p1+1;
                p2 = p1+1;
            } else {
                p2 = p2+1;
            }
        }
        return result;
    }

    /**
     * 快慢指针分别指向数组头和尾，根据大小分别调整快慢指针
     * 只要数组有序，就应该想到双指针技巧
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int slow = 0;
        int fast = numbers.length-1;
        int[] result = new int[]{0,0};
        while(slow < fast  ){
            if(numbers[slow] + numbers[fast] == target ){
                result[0] = slow+1;
                result[1] = fast+1;
                return result;
            }
            if(numbers[slow] + numbers[fast] < target ){
                slow++;
            } else {
                fast--;
            }
        }
        return result;
    }

}
