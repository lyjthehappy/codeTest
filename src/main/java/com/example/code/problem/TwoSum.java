package com.example.code.problem;

import java.util.Scanner;

public class TwoSum {

    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int firstNum = sc.nextInt();
            int secondNum = sc.nextInt();
            System.out.println(sum(firstNum, secondNum));
        }
    }
}
