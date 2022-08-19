package com.ivan.l_22_08_19.s239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Maximilian_Li
 */
public class s239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        int ptr = 0;
        MyQueue q = new MyQueue();

        // 先将前k个元素放入队列
        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        res[ptr++] = q.peek();

        for (int i = k; i < nums.length; i++) {
            // 删除最先进入队列的元素
            q.poll(nums[i - k]);
            // 向队列中添加元素
            q.add(nums[i]);
            res[ptr++] = q.peek();
        }

        return res;
    }
}

/**
 * 自定义单调双端队列
 */
class MyQueue {

    Deque<Integer> deque = new LinkedList<>();

    /**
     * 添加元素，但保证头到尾是不增序列
     *
     * @param integer 元素
     */
    public void add(Integer integer) {
        while (!deque.isEmpty() && integer > deque.getLast()) {
            System.out.println("in [add], remove " + deque.getLast());
            deque.removeLast();
        }

        System.out.println("in [add], add " + integer);
        deque.add(integer);
    }

    /**
     * 弹出元素
     */
    public void poll(Integer integer) {
        if (!deque.isEmpty() && integer.equals(deque.peek())) {
            System.out.println("in [pol], remove " + integer);
            deque.poll();
        }
        System.out.println("in [pol], failed to remove " + integer);
    }

    /**
     * @return 队列头元素(最大值)
     */
    public Integer peek() {
        return deque.peek();
    }
}
