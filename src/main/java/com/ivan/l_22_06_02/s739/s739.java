package com.ivan.l_22_06_02.s739;

import java.util.Stack;

public class s739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.empty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            res[i] = s.empty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return res;
    }
}
