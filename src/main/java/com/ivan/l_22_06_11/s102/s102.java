package com.ivan.l_22_06_11.s102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class s102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int range = q.size();
            for (int i = 0; i < range; i++) {
                TreeNode node = q.poll();
                assert node != null;
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(level);
        }

        return result;
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
