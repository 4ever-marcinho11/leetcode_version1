package com.ivan.l_22_08_19.s1047;

import java.util.Stack;

/**
 * @author Maximilian_Li
 */
public class s1047 {
    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。<br>
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。<br>
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * @param s 字符串
     * @return 删除后的字符串
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        StringBuilder b = new StringBuilder();
        while (stack.size() > 0) {
            b.append(stack.pop());
        }

        return b.reverse().toString();
    }
}
