package com.ivan.l_22_08_30.s654;

public class s654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int length = nums.length;
        return construct(nums, 0, length - 1);
    }

    public TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            // 错位
            return null;
        }
        if (start == end) {
            // 叶子节点
            return new TreeNode(nums[start]);
        }

        // 从范围内找最大值
        int rootVal = 0;
        int rootIdx = 0;
        for (int i = start; i <= end; i++) {
            if (rootVal < nums[i]) {
                rootVal = nums[i];
                rootIdx = i;
            }
        }

        // 构造二叉树
        TreeNode root = new TreeNode(rootVal);
        root.left = construct(nums, start, rootIdx - 1);
        root.right = construct(nums, rootIdx + 1, end);

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
