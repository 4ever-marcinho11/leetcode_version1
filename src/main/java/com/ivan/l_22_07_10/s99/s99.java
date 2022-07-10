package com.ivan.l_22_07_10.s99;


public class s99 {
    public TreeNode one, another, visited;

    public void recoverTree(TreeNode root) {
        in(root);

        int temp = one.val;
        one.val = another.val;
        another.val = temp;
    }

    public void in(TreeNode n) {
        if (n == null) {
            return;
        }

        in(n.left);

        if (visited != null && visited.val > n.val) {
            one = one == null ? visited : one;
            another = n;
        }
        visited = n;

        in(n.right);
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
