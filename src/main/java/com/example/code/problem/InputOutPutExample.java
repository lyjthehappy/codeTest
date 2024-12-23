package com.example.code.problem;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class InputOutPutExample {

    class Node {
        private Integer value;

        Node next;
        Node last;
    }

    //    内部类
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        log.info("end");
        while (sc.hasNext()) {
            String line = sc.nextLine();
            log.info("aline -{}", line);
        }
        log.info("end");
    }

}
