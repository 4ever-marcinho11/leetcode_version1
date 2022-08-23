package com.ivan.l_22_08_23.s222;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Maximilian_Li
 */
public class s222 {
    /**
     * 使用层序遍历的方式得到节点个数
     *
     * @param root 根节点
     * @return 节点个数
     */
    public int levelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;

        q.offer(root);
        while (!q.isEmpty()) {
            int range = q.size();
            for (int i = 0; i < range; i++) {
                TreeNode node = q.poll();
                count++;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return count;
    }

    /**
     * 使用递归的方式得到节点个数
     *
     * @param root 根节点
     * @return 节点个数
     */
    public int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recursive(root.left);
        int right = recursive(root.right);

        return left + right + 1;
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
