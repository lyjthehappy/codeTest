package com.example.code.problem;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.add(21);
        integers.add(21);
        integers.add(212);
        while (!integers.isEmpty()) {
            Integer pop = integers.pop();
            System.out.println(pop);
        }
    }
}
