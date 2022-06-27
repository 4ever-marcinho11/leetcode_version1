package com.ivan.l_22_06_27.s111;


import java.util.LinkedList;
import java.util.Queue;

public class s111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layers = 1;

        while (!queue.isEmpty()) {
            int range = queue.size();
            for (int i = 0; i < range; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    System.out.println("在第 " + layers + " 层退出");
                    return layers;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println("在增加层数之前，层数为: " + layers);
            layers++;
            System.out.println("在增加层数之后，层数为: " + layers);
        }

        return -1;
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
