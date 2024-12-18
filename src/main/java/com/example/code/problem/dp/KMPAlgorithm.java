package com.example.code.problem.dp;

public class KMPAlgorithm {

    // 构建 next 数组
    private static int[] buildNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        next[0] = -1; // next[0] 设置为 -1
        int j = -1;

        for (int i = 1; i < m; i++) {
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }
            if (pattern.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            next[i] = j; // 记录当前状态的前缀长度
        }
        return next;
    }

    // KMP 字符串匹配
    public static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] next = buildNext(pattern);
        int j = -1; // 模式串的指针
        for (int i = 0; i < n; i++) {
            while (j >= 0 && text.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j]; // 回溯
            }
            if (text.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            if (j == m - 1) { // 找到匹配
                return i - j; // 返回匹配的起始位置
            }
        }
        return -1; // 没有找到匹配
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        int result = kmpSearch(text, pattern);

        if (result != -1) {
            System.out.println("模式串在文本中的起始位置: " + result);
        } else {
            System.out.println("未找到模式串");
        }
    }

    public static int[] buildNext1(String pattern) {
        int l = pattern.length();
        int[] next = new int[l];
        next[0] = -1; //初始为0；开始第一个匹配上则为0；
        int j = -1;

        for (int i = 1; i < l; i++) {
            while (j > -1 && pattern.charAt(i) != pattern.charAt(j + 1)) {
                //j>-1 指的是在匹配状态   不相等指的是不能继续了
                j = next[j];   //重新计算当前匹配值
            }

            if (pattern.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }

            next[i] = j;
        }
        return next;

    }


    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int KMP(String ts, String ps) {

        char[] t = ts.toCharArray();

        char[] p = ps.toCharArray();

        int i = 0; // 主串的位置

        int j = 0; // 模式串的位置
        int[] next = getNext(ps);
        while (i < t.length && j < p.length) {

            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;

            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }

        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }


}
