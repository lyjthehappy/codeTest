package com.example.code.problem.hot100.hash;

import java.util.Arrays;
import java.util.List;

public class learnHash {


    public static void main(String[] args) {

        int length = args.length;
        System.out.println(args[0]);
        List<List<String>> arrs = Arrays.asList(Arrays.asList("1", "2", "3", "4", "5"),
                Arrays.asList("1", "2", "3", "4", "5"),
                Arrays.asList("1", "2", "3", "4", "5"),
                Arrays.asList("1", "2", "3", "4", "5"),
                Arrays.asList("1", "2", "3", "4", "5")
        );


        //初始化
        int l = 0, r = arrs.get(0).size();
        int t = 0, b = arrs.size();


        while (l < r) {
            //从左到右
            for (int i = l; i < r; i++) {
                System.out.print(arrs.get(t).get(i));
            }
            t++;
            System.out.println();
            for (int i = t; i < b; i++) {
                System.out.print(arrs.get(i).get(r - 1));
            }
            r--;
            System.out.println();
            for (int i = r - 1; i >= l; i--) {
                System.out.print(arrs.get(b-1).get(i));
            }
            b--;
            System.out.println();
            for (int i = b - 1; i >= t; i--) {
                System.out.print(arrs.get(i).get(l));
            }
            l++;

            System.out.println();
        }
    }
}
