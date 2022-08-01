package com.ivan.l_22_08_01.s108;

public class s108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        // 找到根节点
        int rootIdx = (start + end) / 2;
        TreeNode root = new TreeNode(nums[rootIdx]);

        // 递归得到左右子树
        root.left = sortedArrayToBST(nums, start, rootIdx - 1);
        root.right = sortedArrayToBST(nums, rootIdx + 1, end);

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

