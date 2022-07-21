package com.ivan.l_22_07_21.s705;

public class s705 {
}

class MyHashSet {
    private ListNode hashSet;

    public MyHashSet() {
        hashSet = new ListNode();
        hashSet.next = null;
    }

    /**
     * 向哈希集合插入值key，如果已存在这个值，则不做任何操作
     *
     * @param key 值
     */
    public void add(int key) {
        ListNode pre = hashSet, ptr = pre.next;

        while (ptr != null) {
            if (ptr.val == key) {
                return;
            }
            pre = pre.next;
            ptr = ptr.next;
        }

        // 添加
        pre.next = new ListNode(key);
    }

    /**
     * 将给定值key从哈希集合中删除，如果哈希集合中没有这个值，什么也不做。
     *
     * @param key 值
     */
    public void remove(int key) {
        ListNode pre = hashSet, ptr = pre.next;
        while (ptr != null) {
            if (ptr.val == key) {
                pre.next = ptr.next;
            }
            pre = pre.next;
            ptr = ptr.next;
        }
    }

    /**
     * 返回哈希集合中是否存在这个值key
     *
     * @param key 值
     * @return 是否存在
     */
    public boolean contains(int key) {
        ListNode pre = hashSet, ptr = pre.next;
        while (ptr != null) {
            if (ptr.val == key) {
                return true;
            }
            pre = pre.next;
            ptr = ptr.next;
        }
        return false;
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

