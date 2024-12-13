package com.example.code.problem;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Texample {

    //内部类拥有 private 与protected 权限

    @NoArgsConstructor
    @Data
    public static class A implements AI<Integer> {
        A(int value) {
            this.value = value;
        }

        int value;

        @Override
        public boolean isOk(Boolean isok) {
            return value > 0;
        }

        @Override
        public void sayClass() {
            System.out.println(Integer.class);
        }
    }

    public interface AI<T> {
        boolean isOk(Boolean isok);

        void sayClass();

    }

    public static void main(String[] args) {
        A name = new A(2);

        Comparator<Integer> a;
        a = (o1, o2) -> 0;
        ArrayList<Integer> integers = new ArrayList<>();
        List<Integer> collect = integers.stream().sorted(a).collect(Collectors.toList());




    }


    public static List<? super A> testSuper(List<? super A> list) {
        A a = new A(20);
        list.add(a);
        list.add(a);
        return list;
    }

    public static void testExtends(List<? extends  A> list){
        for (A a : list) {
            System.out.println(a);
        }
    }

    interface Inter1<T1> {
        void say(T1 t1);
    }

    interface Inter2<T1, T2, T3> extends Inter1<T2> {
        void sayT1();

        void sayT3(T3 t3);
    }
}
