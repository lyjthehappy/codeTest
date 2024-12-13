package com.example.code.problem;

import java.util.PriorityQueue;

public class PriorityQueueT {


    private void test() {

        PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) -> {
            if (o1 == o2) return 0;
            if (o1 > o2) return 1;
            return -1;

        });

        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        while (!integers.isEmpty()) {
            System.out.println(integers.poll());
        }
    }

    public static void main(String[] args) {
        PriorityQueueT priorityQueueT = new PriorityQueueT();
        priorityQueueT.test();
    }


}
