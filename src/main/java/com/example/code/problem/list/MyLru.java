package com.example.code.problem.list;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
public class MyLru<T> {

    class Node<T> {

        Node(T t) {
            this.value = t;
        }

        T value;
        Node next;
        Node last;
    }

    int size;

    Map<String, Node<T>> key2Value = new HashMap<>();

    Node<T> first = null;
    Node<T> end = null;

    int count = 0;

    MyLru(int size) {
        this.size = size;
        this.count = 0;
    }

    public void put(String key, T t) {
        if (key2Value.containsKey(key)) {
//            将该节点放置至开头
            key2Value.get(key).value = t;
            moveTofirst(key2Value.get(key));
            return;
        }

        count++;
        //增加新节点
        if (count > size) {
            //淘汰
            log.info("淘汰尾节点-{}", end.value);
            end = end.last;
            end.next = null;
            count--;
        }


        Node node = new Node(t);
        if (count == 1) {
            first = node;
            end = node;
        } else {
            node.next = first;
            first.last = node;
            first = node;
        }
        key2Value.put(key, node);
    }

    public T get(String key) {
        if (key2Value.containsKey(key)) {
            moveTofirst(key2Value.get(key));
            return key2Value.get(key).value;
        }
        return null;
    }


    public void moveTofirst(Node node) {
        if (node.next != null) {
            node.last.next = node.next;
            node.next = first;
            first = node;
        }
    }

    public static void main(String[] args) {

        MyLru<Integer> myLru = new MyLru<Integer>(3);
        myLru.put("1", 1);
        myLru.put("2", 2);
        myLru.put("3", 3);
        myLru.put("4", 4);
        myLru.put("5", 5);
        myLru.put("3", 4);
        Integer integer = myLru.get("4");
        System.out.println(myLru);
    }
}
