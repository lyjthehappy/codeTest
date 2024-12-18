package com.example.code.problem.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayExample {


    /**
     * 链表
     */
    class ListNode {
        private int value;
        private ListNode next;

        ListNode(int x) {
            value = x;
        }
    }

    /**
     * 构建链表
     *
     * @param arrs
     * @return
     */
    public ListNode createLinkedList(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        for (int num : arrs) {
            ListNode listNode = new ListNode(num);
            cur.next = listNode;
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * 链表反转
     *
     * @param listNode
     * @return
     */
    public ListNode reverseLinkedList(ListNode listNode) {
        if (listNode == null) {
            return null;
        }

        ListNode cur = listNode;
        ListNode tail = null;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = tail;
            tail = cur;
            cur = tmp;
        }
        return tail;
    }

    public void scanLinkedArray(ListNode listNode) {
        ListNode cur = listNode;
        while (cur != null) {
            System.out.println("this node value is : " + cur.value);
            cur = cur.next;
        }
        System.out.println("scan end");
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        ListNode linkedList = arrayExample.createLinkedList(new int[]{1, 3, 4, 5});
        arrayExample.scanLinkedArray(linkedList);
        ListNode reverse = arrayExample.reverseLinkedList(linkedList);
        arrayExample.scanLinkedArray(reverse);
    }






    private void test() {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        int a = arr[0];
//        随机访问  非线程安全、 1.5倍扩容    element的size 预分配
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (true) {
            arrayList.add(1);
        }

//        Vector<Integer> integers = new Vector<>();
//        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<Integer>();
    }


}
