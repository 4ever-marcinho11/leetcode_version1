package com.ivan.l_22_07_21.s706;

public class s706 {
}

class MyHashMap {
    private ListNode hashMap;

    public MyHashMap() {
        hashMap = new ListNode();
    }

    /**
     * 向hash map插入一个键值对，如果key已存在，则更新value
     *
     * @param key   键
     * @param value 值
     */
    public void put(int key, int value) {
        ListNode pre = hashMap, ptr = pre.next;

        while (ptr != null) {
            if (ptr.key == key) {
                ptr.val = value;
                return;
            }
            pre = pre.next;
            ptr = ptr.next;
        }

        pre.next = new ListNode(key, value, null);
    }

    /**
     * 返回特定的key所映射的value，如果映射中不包含key的映射，则返回-1
     *
     * @param key 键
     * @return 值或-1
     */
    public int get(int key) {
        ListNode pre = hashMap, ptr = pre.next;

        while (ptr != null) {
            if (ptr.key == key) {
                return ptr.val;
            }
            pre = pre.next;
            ptr = ptr.next;
        }

        return -1;
    }

    /**
     * 如果映射中存在key的映射，则移除key和他所对应的value
     *
     * @param key 键
     */
    public void remove(int key) {
        ListNode pre = hashMap, ptr = pre.next;

        while (ptr != null) {
            if (ptr.key == key) {
                pre.next = ptr.next;
            }
            pre = pre.next;
            ptr = ptr.next;
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;

    ListNode() {
        this.next = null;
    }

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
