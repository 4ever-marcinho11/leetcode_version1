package com.ivan.l_22_05_29.s300;

public class s300 {
    public int maxUpUncontinuously(int[] nums) {
        // 牌堆顶的牌的集合
        int[] top = new int[nums.length];

        // 实际的牌堆数目
        int piles = 0;

        for (int poker : nums) {
            // 在牌堆中找到可以放置的位置
            // 放置规则：小压在大的牌上面/小压在相等的牌上面；当有多个牌堆可供选择时选择最左侧的
            // 使用方法：在top中寻找对应牌的左侧边界。找到牌堆就放入牌堆顶，没找到就新建一堆
            int left = 0, right = piles, mid = 0;

            // 为什么可以直接使用二分搜索？
            // 因为根据上述规则，top永远是有序的数组
            while (left < right) {
                mid = left + (right - left) / 2;
                if (poker == top[mid]) {
                    right = mid;
                } else if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid;
                }
            }

            // 找到合适位置的话left < piles
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }

    /**
     * 寻找左侧边界的二分查找
     */
    public int leftBs(int[] nums, int target) {
        int left = 0, right = nums.length, mid = 0;

        // 返回left，就收缩右侧边界
        // left=right是退出循环的标准，因此不能取等
        while (left < right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
