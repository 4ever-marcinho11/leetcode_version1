package com.ivan.l_22_12_07.s503;

import java.util.Deque;
import java.util.LinkedList;

public class s503 {
    /**
     * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
     * <p>
     * 如果不存在，则输出 -1。
     *
     * @param nums 循环数组（nums[nums.length - 1]的下一个元素是nums[0]）
     * @return 返回nums中每个元素的 下一个更大元素
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> d = new LinkedList<>();

        // 扩容一倍
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!d.isEmpty() && d.getLast() <= nums[i % nums.length]) {
                d.removeLast();
            }

            ans[i % nums.length] = d.isEmpty() ? -1 : d.getLast();
            d.addLast(nums[i % nums.length]);
        }

        return ans;
    }
}
