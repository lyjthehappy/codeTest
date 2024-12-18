package com.example.code.problem.list;

public class CycleArray<T> {

    private T[] arr;
    private int start;
    private int end;
    private int count;
    private int size;

    public CycleArray(int size) {
        this.size = size;
        this.arr = (T[]) new Object[size];
        this.start = 0;
        this.end = 0;
        this.count = 0;

    }


    private void resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size];
        }
        this.arr = newArr;
        start = 0;
        end = count;
        size = newSize;
    }




}
