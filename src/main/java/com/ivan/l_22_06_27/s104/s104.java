package com.ivan.l_22_06_27.s104;

import java.util.LinkedList;
import java.util.Queue;

public class s104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int layers = 1;

        while (!q.isEmpty()) {
            int range = q.size();
            int count = 0;

            for (int i = 0; i < range; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    count++;
                    if (count == range) {
                        return layers;
                    }
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            layers++;
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

