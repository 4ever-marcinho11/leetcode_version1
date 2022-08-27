package com.ivan.l_22_08_27.s113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s113 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * @param root      根节点
     * @param targetSum 和
     * @return 节点集合
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }

        traversal(root, targetSum);
        return result;
    }

    public void traversal(TreeNode node, int targetSum) {
        path.add(node.val);

        // 叶子节点是递归的返回条件
        if (node.left == null && node.right == null) {
            if (targetSum - node.val == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if (node.left != null) {
            // 递归
            traversal(node.left, targetSum - node.val);
            //回溯
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            traversal(node.right, targetSum - node.val);
            path.remove(path.size() - 1);
        }
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
