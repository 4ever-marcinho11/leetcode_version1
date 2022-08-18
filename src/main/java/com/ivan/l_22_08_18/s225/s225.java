package com.ivan.l_22_08_18.s225;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 仅使用两个队列实现一个后入先出（LIFO）的栈
 *
 * @author Maximilian_Li
 */
public class s225 {

    private final Queue<Integer> maj;
    private final Queue<Integer> min;

    public s225() {
        maj = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        maj.add(x);
    }

    public int pop() {
        while (maj.size() > 1) {
            min.add(maj.poll());
        }

        int popped = Objects.requireNonNull(maj.poll());

        while (!min.isEmpty()) {
            maj.add(min.poll());
        }

        return popped;
    }

    public int top() {
        while (maj.size() > 1) {
            min.add(maj.poll());
        }

        int peeked = Objects.requireNonNull(maj.peek());
        min.add(maj.poll());

        while (!min.isEmpty()) {
            maj.add(min.poll());
        }

        return peeked;
    }

    public boolean empty() {
        return maj.isEmpty();
    }
}
