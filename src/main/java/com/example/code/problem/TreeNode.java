package com.example.code.problem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode<T> {

    @Data
    class B {
        Integer a;

        public void say() {
            System.out.println("i am B");

        }
    }

    @Data
    class C extends B {
    }


    class A<T> extends B {
        T value;
    }


    TreeNode(T value) {
        this.value = value;
    }

    private T value;

    private TreeNode left;

    private TreeNode right;


    public static <T extends Integer> void test(T a, int b) {

    }


    public void main(String[] args) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(new TreeNode<>(1));
        treeNodes.add(new TreeNode<>(2));
        treeNodes.add(new TreeNode<>(3));
        treeNodes.add(new TreeNode<>(4));
        treeNodes.add(new TreeNode<>(5));
        treeNodes.add(new TreeNode<>(6));


        TreeNode treeNode = buildTree(treeNodes);
        scanTreeDfs(treeNode);


        // ？ 通配符用于定义
        A<? extends B> a = null;
        A<C> a1 = new A<>();
        a = a1;
        a.say();

    }

    public static void scan(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        scanTreeDfs(treeNode);
    }


    /**
     * dfs
     *
     * @param treeNode
     */
    public static void scanTreeDfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.value);
        scanTreeDfs(treeNode.getLeft());
        scanTreeDfs(treeNode.getRight());
    }

    private static TreeNode buildTree(List<TreeNode> treeNodes) {

        int i = 0;
        int j = 1;
        while (j < treeNodes.size()) {
            TreeNode treeNodeRoot = treeNodes.get(i);
            TreeNode treeNode = treeNodes.get(j);
            treeNodeRoot.setLeft(treeNode);
            if (j + 1 < treeNodes.size()) {
                treeNodeRoot.setRight(treeNodes.get(j + 1));
            }
            i++;
            j += 2;
        }

        return treeNodes.get(0);
    }


}
