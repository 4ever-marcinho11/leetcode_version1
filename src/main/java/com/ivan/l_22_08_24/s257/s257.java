package com.ivan.l_22_08_24.s257;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        findPath(root, path, res);
        return res;
    }

    /**
     * 使用前序遍历的方式记录路径
     *
     * @param n    当前节点
     * @param path 路径集
     * @param res  结果集
     */
    public void findPath(TreeNode n, List<Integer> path, List<String> res) {
        path.add(n.val);
        // 如果是叶子节点
        if (n.left == null && n.right == null) {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                String ch = path.get(i) + "";
                b.append(ch);
                b.append("->");
            }
            b.append(path.get(path.size() - 1));

            res.add(b.toString());
            return;
        }

        // 因为上面没有处理当前节点是否非空，因此在这里要判断非空
        if (n.left != null) {
            findPath(n.left, path, res);
            // 回溯至上一个节点
            path.remove(path.size() - 1);
        }

        if (n.right != null) {
            findPath(n.right, path, res);
            // 回溯至上一个节点
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
