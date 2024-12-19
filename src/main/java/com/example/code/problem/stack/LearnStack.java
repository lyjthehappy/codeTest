package com.example.code.problem.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LearnStack {


    //单调栈 单调栈 遇到第一个高于
    public static void learn1() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
//        找出每个元素右边第一个比它大的元素
        int[] res = new int[arr.size()];  // 寻找右边第一个元素

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.size(); i++) {
//            维护一个单调减栈
            while (!stack.isEmpty() && arr.get(stack.peek()) <= arr.get(i)) {
                Integer curIdx = stack.pop();
                res[curIdx] = arr.get(i);
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }


//    在一个序列中快速定位满足特定条件的最长或最短子序列
//    直方图中最大的矩形面积
//      维护一个单调递增区间   暴力破解  单调矩阵是减支  从而减少了复杂度

//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨后能接多少雨水。


    public static void main(String[] args) {
        learn1();


    }

    //单调队列

    //单调队列

    //求区间内最值问题




}
