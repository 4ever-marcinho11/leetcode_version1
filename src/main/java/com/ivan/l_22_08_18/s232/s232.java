package com.ivan.l_22_08_18.s232;

import java.util.Stack;

/**
 * 仅使用两个栈实现先入先出队列
 *
 * @author Maximilian_Li
 */
public class s232 {
    private final Stack<Integer> majority;
    private final Stack<Integer> minority;

    public s232() {
        majority = new Stack<>();
        minority = new Stack<>();
    }

    public void push(int x) {
        majority.push(x);
    }

    public int pop() {
        // 找到栈底元素
        while (majority.size() > 1) {
            Integer ele = majority.pop();
            minority.push(ele);
        }

        int popped = majority.pop();

        // 恢复原栈
        while (!minority.empty()) {
            Integer ele = minority.pop();
            majority.push(ele);
        }

        return popped;
    }

    public int peek() {
        // 找到栈底元素
        while (majority.size() > 1) {
            Integer ele = majority.pop();
            minority.push(ele);
        }

        int peeked = majority.peek();

        // 恢复原栈
        while (!minority.empty()) {
            Integer ele = minority.pop();
            majority.push(ele);
        }

        return peeked;
    }

    public boolean empty() {
        return majority.empty();
    }
}
