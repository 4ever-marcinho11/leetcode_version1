package com.ivan.l_22_12_05.s739;

import java.util.Stack;

public class s739 {
    /**
     * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。
     * <p>
     * 如果气温在这之后都不会升高，请在该位置用0来代替
     *
     * @param temperatures 整数数组
     * @return 数组
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        // stack存放每一天的索引
        Stack<Integer> stack = new Stack<>();

        // 由于answer[i]指的是下一次更高温度的日期间隔，所以要倒序
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            answer[i] = stack.empty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }

        return answer;
    }
}
