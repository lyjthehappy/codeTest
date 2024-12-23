package com.example.code.problem.sort;

public class QuickSort {

    public int[] quickSort(int[] arr) {
        quickSortHelp(arr, 0, arr.length - 1);
        return arr;
    }

    void quickSortHelp(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = getMiddle(arr, l, r);
        quickSortHelp(arr, l, mid - 1);
        quickSortHelp(arr, mid + 1, r);
    }

    int getMiddle(int[] arr, int l, int r) {
        int value = arr[l];
        int first = l;

        while (l < r) {

            //关键戴安 先找
            while (l < r && arr[r] >= value) r--;

//            找到左边大于value的值
            while (l < r && arr[l] <= value) l++;


            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, first, l);
        return l;
    }

    void swap(int[] arr, int l, int r) {
        int tmp = arr[r];
        arr[r] = arr[l];
        arr[l] = tmp;
    }

    public void scan(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        int[] sortArr = quickSort.quickSort(new int[]{5, 4, 6, 1, 7});
        quickSort.scan(sortArr);


    }


}
