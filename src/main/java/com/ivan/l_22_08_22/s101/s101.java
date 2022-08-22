package com.ivan.l_22_08_22.s101;

/**
 * @author Maximilian_Li
 */
public class s101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compare(root.left, root.right);
    }

    /**
     * 判断root的左右节点是否相同
     *
     * @param left  左节点
     * @param right 右节点
     * @return boolean
     */
    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            // 左不空，右空
            return false;
        } else if (left == null && right != null) {
            // 右不空，左空
            return false;
        } else if (left == null && right == null) {
            // 都空
            return true;
        } else if (left.val != right.val) {
            // 左右值不同
            return false;
        }

        // 左右值相同的时候需要进行递归，判断下一层
        boolean outer = compare(left.left, right.right);
        boolean inner = compare(left.right, right.left);

        // 注意不能返回 outer == inner，因为都为false的时候不能正确返回结果
        return outer && inner;
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
