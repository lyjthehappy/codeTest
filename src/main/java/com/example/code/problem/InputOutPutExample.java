package com.example.code.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutPutExample {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);


//        //输入五个数字
//        int i=5;
//        List<Integer> nums = new ArrayList<>();
//        while (i-->0){
//            int num = scanner.nextInt();
//            nums.add(num);
//        }
//        nums.forEach(System.out::println);
//
//        scanner.close();
        //输入任意数字直到输入EOF

        // 使用has next 结尾
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        System.out.println("input is over");




    }


}
