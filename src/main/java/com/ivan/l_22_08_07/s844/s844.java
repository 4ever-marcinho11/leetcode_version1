package com.ivan.l_22_08_07.s844;

import java.util.Stack;

/**
 * @author Maximilian_Li
 */
public class s844 {
    public boolean backspaceCompare(String s, String t) {
        char backspace = '#';

        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != backspace) {
                a.push(s.charAt(i));
            } else {
                if (!a.empty()) {
                    a.pop();
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != backspace) {
                b.push(t.charAt(i));
            } else {
                if (!b.empty()) {
                    b.pop();
                }
            }
        }

        // 全空，返回true
        if (a.empty() && b.empty()) {
            return true;
        }

        // 数量不同，返回false
        if (a.size() != b.size()) {
            return false;
        }

        // 都不空且数量相同，一个一个取出来，只要有不一样的就退出循环
        while (!a.empty() && !b.empty() && a.peek().equals(b.peek())) {
            a.pop();
            b.pop();
        }

        return a.empty() && b.empty();
    }
}
