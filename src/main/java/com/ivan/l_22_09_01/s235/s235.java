package com.ivan.l_22_09_01.s235;

/**
 * @author Maximilian_Li
 */
public class s235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 二叉搜索树有序，不必用自底向上的后序遍历了，使用自顶向上的遍历方式即可
        if (root.val > p.val && root.val > q.val) {
            // p,q都在root左边
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (root.val < p.val && root.val < q.val) {
            // p,q都在root右边
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
