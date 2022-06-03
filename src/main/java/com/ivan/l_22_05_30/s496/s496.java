package com.ivan.l_22_05_30.s496;

import java.util.Stack;

/**
 * @author Maximilian_Li
 */
public class s496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 找nums1中某元素在nums2中对应位置之后的更大的元素
        // 由此可见，nums1是nums2的一个子集
        int[] res1 = new int[nums1.length];
        int[] res2 = new int[nums2.length];
        Stack<Integer> s = new Stack<>();

        // 找nums2的下一个最大元素
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 当s内有元素的时候，就要拿这个栈顶元素与目标元素比较，s中只留大的
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            // 要么取下一个更大，要么取-1
            res2[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums2[i]);
        }

        // 根据nums1中元素在nums2的位置，在nums2的下一个最大元素找结果
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res1[i] = res2[j];
                }
            }
        }

        return res1;
    }
}
