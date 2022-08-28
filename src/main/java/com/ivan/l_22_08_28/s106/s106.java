package com.ivan.l_22_08_28.s106;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s106 {
    /**
     * 根据后序遍历与中序遍历构造二叉树
     *
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @return 构造出的树的根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> mapper = new HashMap<>();

        int size = inorder.length;
        for (int i = 0; i < size; i++) {
            mapper.put(inorder[i], i);
        }

        return buildInTwoArr(
                postorder, 0, size - 1,
                inorder, 0, size - 1,
                mapper
        );
    }


    /**
     * 根据两个数组与两个数组的起始与中止索引递归地构造出一颗二叉树
     *
     * @param post        后序遍历数组
     * @param startOfPost 起始索引
     * @param endOfPost   中止索引
     * @param in          中序遍历数组
     * @param startOfIn   起始索引
     * @param endOfIn     中止索引
     * @param mapper      映射表
     * @return 根节点
     */
    public TreeNode buildInTwoArr(int[] post,
                                  int startOfPost,
                                  int endOfPost,
                                  int[] in,
                                  int startOfIn,
                                  int endOfIn,
                                  HashMap<Integer, Integer> mapper) {

        if (startOfPost > endOfPost || startOfIn > endOfIn) {
            return null;
        }

        // 根据后序遍历获取根节点索引
        int rootIdxInPost = endOfPost;
        // 找到这个节点在中序遍历数组中的位置
        int locOfRootInIn = mapper.get(post[rootIdxInPost]);
        // 记录该根节点的左子树的节点数量
        int numInLeft = locOfRootInIn - startOfIn;

        // 构造根节点
        TreeNode root = new TreeNode(post[rootIdxInPost]);
        // 构造根节点的左子节点与右子节点
        root.left = buildInTwoArr(
                post, startOfPost, startOfPost + numInLeft - 1,
                in, startOfIn, locOfRootInIn - 1,
                mapper
        );
        root.right = buildInTwoArr(
                post, startOfPost + numInLeft, endOfPost - 1,
                in, locOfRootInIn + 1, endOfIn,
                mapper
        );

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

