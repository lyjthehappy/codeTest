package com.example.code.problem.dp;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class LearnDP {

    // 状态转移方程  // 最优子结构   // 重叠子问题   //备忘录   //dptable

    //自顶向下  跟自底向上


    //    编辑距离
//    E[i][j] = min{ E[i-1][j] + 1, E[i][j-1]+1, E[i-1][j-1] + diff(i, j) }
    public static void learn() {
        String a = "abc";
        String b = "cde";

        int[][] dp = new int[a.length()][b.length()];
        //dp[i][j] 标识 sub0i 到 sub[0j]之间的最小编辑距离  dp[i][j]= min(dp[i-1][j],dp[i][j-1], {dp[i-1][j-1] + diff[i,j})
//        如何记录操作速度
        String[][] op = new String[a.length()][b.length()];  //记录下数据发生顺序   需要的话

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;  //bad case
                } else if (j == 0) {
                    dp[i][j] = i; //bad case
                } else {

                    String tmpPo = "";
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        tmpPo = "在dp[" + (i - 1) + "][" + j + "]的基础上" + "增加一个字符:" + b.charAt(j);
                    } else {
                        tmpPo = "在dp[" + (i) + "][" + (j - 1) + "]的基础上" + "删除一个字符:" + b.charAt(j);
                    }

                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    if (a.charAt(i) == b.charAt(j) && dp[i][j] > dp[i - 1][j - 1]) {
                        tmpPo = "在dp[" + (i - 1) + "][" + (j - 1) + "]的基础上" + "同时加上原来字符:" + b.charAt(j);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    } else if (dp[i][j] > dp[i - 1][j - 1] + 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                        tmpPo = "在dp[" + (i - 1) + "][" + (j - 1) + "]的基础上" + "同时加上原来字符:" + b.charAt(j) + "并变换一个字符";
                    }
                    op[i][j] = tmpPo;
                }
            }
        }

        System.out.println(dp[a.length() - 1][b.length() - 1]);
        for (int i = 0; i < op.length; i++) {
            for (int i1 = 0; i1 < op[i].length; i1++) {
                System.out.print(op[i][i1] + "  ");
            }
            System.out.println();
        }

    }


    /**
     * 股票问题   dpH
     */
    public static void learn2(int[] price) {


    }

    /**
     * 背包问题
     *
     * @param args
     */

    public int learn01(int[] price, int[] volume, int v) {
        int[] dp = new int[v + 1];
        int[] g = new int[v + 1];

        for (int i = 0; i <= price.length; i++) {
            for (int j = 0; j <= v; j++) {
                if (i == 0) dp[j] = 0;
                else {
                    if (j >= volume[i - 1]) {
                        dp[j] = Math.min(dp[j], dp[j - volume[i - 1] + price[i - 1]]);
                    }
                }
            }
        }
        return dp[v];
    }

    public int learn08(int[] price, int[] volume, int v) {

        int[] dp = new int[v + 1];
        int[] g = new int[v + 1];
        g[0] = 1;
        for (int i = 0; i <= price.length; i++) {
            for (int j = 0; j <= v; j++) {
                if (i == 0) dp[j] = 0;
                else {
                    if (j >= volume[i - 1]) {
                        dp[j] = Math.min(dp[j], dp[j - volume[i - 1] + price[i - 1]]);
                        if (dp[j] == dp[j - volume[i - 1] + price[i - 1]]) {
                            g[j] = g[j] + g[j - volume[i - 1]];
                        } else if (dp[j] < dp[j - volume[i - 1] + price[i - 1]]) {
                            g[j] = g[j - volume[i - 1]];
                        }
                    }
                }
            }
        }
        return g[v];


    }


    {
        //01背包 特点：每个物品只能用一次，只能是选择或者不选择


//       完全背包 特点：每种物品有无限个，可以选择 0~n 个

        //多重背包 特点：每件物品有 s 件，对于每件物品可以选择 0 ~ s 件

        //混合背包

        // 二维背包  容量与重量

        // 分组背包

        // 求最优方案数   g[i][j]   为前i个物品的

        // 求背包问题的方案  这个记录就好

        //有依赖的背包问题
    }


    public static void main(String[] args) {
        learn();
    }


}
