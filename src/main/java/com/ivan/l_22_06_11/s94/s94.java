package com.ivan.l_22_06_11.s94;

import java.util.ArrayList;
import java.util.List;

public class s94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        in(root, result);
        return result;
    }

    public void in(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        in(node.left, result);
        result.add(node.val);
        in(node.right, result);
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
