package com.ivan.l_22_09_12.s376;

/**
 * @author Maximilian_Li
 */
public class s376 {
    /**
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
     * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     * <p>
     * 例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
     * <p>
     * 相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
     *
     * @param nums 整数数组
     * @return nums中作为摆动序列的最长子序列的长度
     */
    public int wiggleMaxLength(int[] nums) {
        int previous = 0;
        int current = 0;
        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            current = nums[i + 1] - nums[i];
            if ((current > 0 && previous <= 0) || (current < 0 && previous >= 0)) {
                res++;
                previous = current;
            }
        }

        return res;
    }
}
