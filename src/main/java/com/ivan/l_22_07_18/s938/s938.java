package com.ivan.l_22_07_18.s938;


import java.util.ArrayList;

public class s938 {
    private ArrayList<Integer> arr = new ArrayList<>();

    public int rangeSumBST(TreeNode root, int low, int high) {
        // 得到中序遍历的数组
        inorder(root);

        // 求和
        int sum = 0;
        int left = 0;
        int right = arr.size() - 1;

        // 指针移动到指定位置
        while (arr.get(left) < low) {
            left++;
        }
        while (arr.get(right) > high) {
            right--;
        }

        // 求和
        for (int i = left; i <= right; i++) {
            sum += arr.get(i);
        }

        return sum;
    }

    public void inorder(TreeNode n) {
        if (n == null) {
            return;
        }

        inorder(n.left);
        arr.add(n.val);
        inorder(n.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
