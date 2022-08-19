package com.ivan.l_22_08_19.s150;

import java.util.Map;
import java.util.Stack;

/**
 * @author Maximilian_Li
 */
public class s150 {
    Stack<String> s = new Stack<>();

    public int evalRPN(String[] tokens) {

        Map<String, String> ops = Map.of(
                "+", "plus",
                "-", "minus",
                "*", "multiply",
                "/", "divide");

        for (String token : tokens) {
            if (!ops.containsKey(token)) {
                // 数字
                s.push(token);
            } else {
                // 运算符
                String op = ops.get(token);
                int latter = Integer.parseInt(s.pop());
                int former = Integer.parseInt(s.pop());

                calculate(former, latter, op);
            }
        }

        return Integer.parseInt(s.peek());

    }

    private void calculate(int former, int latter, String op) {
        switch (op) {
            case "plus" -> s.push(former + latter + "");
            case "minus" -> s.push(former - latter + "");
            case "multiply" -> s.push(former * latter + "");
            case "divide" -> s.push(former / latter + "");
            default -> System.out.println("in default case...");
        }
    }
}
