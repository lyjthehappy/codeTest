package com.example.code.problem;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Data
@Slf4j
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


    public static void main(String[] args) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(new TreeNode<>(1));
        treeNodes.add(new TreeNode<>(2));
        treeNodes.add(new TreeNode<>(3));
        treeNodes.add(new TreeNode<>(4));
        treeNodes.add(new TreeNode<>(5));
        treeNodes.add(new TreeNode<>(6));


        TreeNode treeNode = buildTree(treeNodes);
        scanTreeDfs(treeNode);
        floorScan(treeNode);


        //构建序列
        List<String> preOrder = Arrays.asList("A", "B", "D", "E", "C", "F", "G");
        List<String> inOrder = Arrays.asList("D", "B", "E", "A", "F", "C", "G");
        TreeNode<String> root = buildTreeByInAndpreOrder(preOrder, inOrder);
        floorScan(root);


        // ？ 通配符用于定义
//        A<? extends B> a = null;
//        A<C> a1 = new A<>();
//        a = a1;
//        a.say();

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


    private static void floorScan(TreeNode root) {
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        int floor = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                TreeNode treeNode = que.pollFirst();
                System.out.print(treeNode.value + " ");
                if (treeNode.left != null)
                    que.offer(treeNode.left);
                if (treeNode.right != null)
                    que.offer(treeNode.right);
            }
            System.out.println();
            floor++;
        }
        System.out.println("floor scan end");

    }


    public static <T> TreeNode<T> buildTreeByInAndpreOrder(List<T> preOrder, List<T> inOrder) {
        return buildTreeByInAndpreOrderHelper(preOrder, 0, preOrder.size() - 1, inOrder, 0, inOrder.size() - 1);
    }


    /**
     * 根据构建
     *
     * @param preOrder
     * @param pl
     * @param pr
     * @param inOrder
     * @param il
     * @param ir
     * @param <T>
     * @return
     */
    public static <T> TreeNode<T> buildTreeByInAndpreOrderHelper(List<T> preOrder, int pl, int pr, List<T> inOrder, int il, int ir) {
        log.info("pl-{},pr-{},il-{},ir-{}", pl, pr, il, ir);
        if (pl > pr) {
            return null;
        }


        T t = preOrder.get(pl);
        TreeNode<T> tmpRoot = new TreeNode<>(t);

        int i;
        for (i = il; i <= ir; i++) {
            if (inOrder.get(i).equals(t)) {
                break;
            }
        }

        int lNodes = i - il;

        int leftPl = pl + 1;
        int leftPr = pl + lNodes;

        int leftIl = il;
        int leftIr = i - 1;

        TreeNode<T> tTreeNode = buildTreeByInAndpreOrderHelper(preOrder, leftPl, leftPr, inOrder, leftIl, leftIr);
        tmpRoot.setLeft(tTreeNode);

        int rightPl = pl + lNodes + 1;
        int rightPr = pr;
        int rightIl = i + 1;
        int rightIr = ir;
        TreeNode<T> rightNode = buildTreeByInAndpreOrderHelper(preOrder, rightPl, rightPr, inOrder, rightIl, rightIr);
        tmpRoot.setRight(rightNode);
        return tmpRoot;
    }


}
