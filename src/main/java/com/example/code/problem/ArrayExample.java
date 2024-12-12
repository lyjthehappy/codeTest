package com.example.code.problem;

import java.util.*;

public class ArrayExample {

    public static class Node {

        Node(int value) {
            this.value = value;
        }

        private int value;
        Node left;
        Node right;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(arr);
        int[] arr2 = new int[100];
        int[][] arr3 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr3[i][j] = 3;
            }
        }


        for (int[] ints : arr3) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.pollFirst();

        Stack<Integer> integers = new Stack<>();


        System.out.println(arr2);
        System.out.println("hello");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Node> nodes = new PriorityQueue<>(100, (o1, o2) -> {
            if (o1.value == o2.value) return 0;
            if (o1.value > o2.value) return -1;
            return 1;
        });

        nodes.add(new Node(2));
        nodes.add(new Node(3));
        nodes.add(new Node(5));
        nodes.add(new Node(24));

        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            System.out.println(poll.value);
        }
    }

    private void testExample() {
        //1 创建数组
        List<Integer> array = new ArrayList<>();
        //2、添加数据
        array.add(1);

        array.add(2);
        //3、删除数据
        array.remove(1);
        array.remove(2);  //a single;

        //4、展示数组
        for (Integer integer : array) {
            System.out.print(integer);
        }

    }
}
