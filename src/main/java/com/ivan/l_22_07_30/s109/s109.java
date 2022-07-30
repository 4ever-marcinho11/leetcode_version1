package com.ivan.l_22_07_30.s109;

public class s109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prev = new ListNode(-1, head);
        ListNode curr = head, next = head;

        // 让curr指向链表中点
        while (next != null && next.next != null) {
            prev = prev.next;
            curr = curr.next;
            next = next.next.next;
        }

        // 断掉prev与curr
        prev.next = null;
        TreeNode root = new TreeNode(curr.val);

        // 左右子树
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(curr.next);

        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
