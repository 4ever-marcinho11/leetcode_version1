package com.ivan.l_22_05_30.s503;

import java.util.Stack;

public class s503 {
    public int[] nextGreaterElements(int[] nums) {
        // 在求nums中所有元素的下一个最大元素中，nums被视作一个环形数组
        // 或者将nums数组扩容一倍，达到循环的目的
        // 这里使用扩容一倍的方法
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        int size = nums.length;
        for (int i = 2 * size - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % size]) {
                s.pop();
            }

            res[i % size] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % size]);
        }
        return res;
    }
}
