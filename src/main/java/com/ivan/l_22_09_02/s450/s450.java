package com.ivan.l_22_09_02.s450;

/**
 * @author Maximilian_Li
 */
public class s450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            //目标节点在右边
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            // 目标节点在左边
            root.left = deleteNode(root.left, key);
        } else {
            // 自己就是目标节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
        }
        return root;
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
