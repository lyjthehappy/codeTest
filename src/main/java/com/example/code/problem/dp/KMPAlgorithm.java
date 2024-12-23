package com.example.code.problem.dp;

public class KMPAlgorithm {

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
            if (j == -1 || t[i] == p[j]) { //   当前搜索位置与匹配字符串不可能无关联，到下一个为止重新开始匹配
                i++;
                j++;
            } else {
                j = next[j]; // j退回到指定位置
            }
        }
        if (j == p.length) {
            return i - j;  //i-j为搜索字符串中匹配字符串开始位置
        } else {
            return -1; // -1 代表搜索不到
        }
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        int result = KMP(text, pattern);
        if (result != -1) {
            System.out.println("模式串在文本中的起始位置: " + result);
        } else {
            System.out.println("未找到模式串");
        }
    }

}
