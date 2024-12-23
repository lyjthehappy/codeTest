package com.example.code.problem.dp;

public class MyKMP {


    private static int[] getNext(String p) {
        char[] pr = p.toCharArray();
        int[] next = new int[p.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pr.length - 1) {
            if (k == -1 || pr[k] == pr[j]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        for (int i : next) {
            System.out.print(i + " ");
        }
        return next;
    }

    public static int kmpSearch(String search, String p) {

        int[] next = getNext(p);

        char[] searchStr = search.toCharArray();
        int i = 0;
        int j = 0;

        while (i < search.length() && j < p.length()) {
            if (j == -1 || searchStr[i] == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == p.length()) {
            return i - j;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {

        int i = kmpSearch("abcabcabcd", "abcabcd");
        System.out.println(i);
    }

}
