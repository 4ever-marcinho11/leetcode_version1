package com.ivan.l_22_06_11.s145;

import java.util.ArrayList;
import java.util.List;

public class s145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        post(result, root);
        return result;
    }

    public void post(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        post(result, node.left);
        post(result, node.right);
        result.add(node.val);
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