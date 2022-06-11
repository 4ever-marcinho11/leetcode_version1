package com.ivan.l_22_06_11.s144;

import java.util.ArrayList;
import java.util.List;

public class s144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        pre(result, root);
        return result;
    }

    public void pre(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        pre(result, node.left);
        pre(result, node.right);
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
