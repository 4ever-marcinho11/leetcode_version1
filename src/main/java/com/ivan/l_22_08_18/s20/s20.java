package com.ivan.l_22_08_18.s20;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Maximilian_Li
 */
public class s20 {
    /**
     * @param s 括号串
     * @return 是否合规
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        Set<Character> left = Set.of('(', '[', '{');
        Set<Character> right = Set.of(')', ']', '}');
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (left.contains(ch)) {
                // 左半边，直接入栈
                stack.push(ch);
            } else {
                // 右半边
                // 首先一定不能空栈
                if (stack.empty()) {
                    return false;
                } else {
                    // 不匹配一定是错的，匹配就将对应左括号推出栈
                    if (map.get(stack.peek()) != ch) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.empty();
    }
}
