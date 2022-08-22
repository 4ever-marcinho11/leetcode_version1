package com.ivan.l_22_08_22.s226;

/**
 * @author Maximilian_Li
 */
public class s226 {
    /**
     * 使用前序遍历的方式反转一棵二叉树
     *
     * @param root 根节点
     * @return 反转后的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
