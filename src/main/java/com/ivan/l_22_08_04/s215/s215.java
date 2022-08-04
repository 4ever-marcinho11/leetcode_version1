package com.ivan.l_22_08_04.s215;

public class s215 {
    public int bubbleSort(int[] nums, int k) {
        // 排序
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        // 返回
        return nums[nums.length - k];
    }

    public int quickSort(int[] nums, int k) {
        // 排序
        quickSort(nums, 0, nums.length - 1);

        // 返回
        return nums[nums.length - k];
    }

    /**
     * 快速排序
     *
     * @param array 数组
     * @param left  左
     * @param right 右
     */
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int loc = partition(array, left, right);

        quickSort(array, left, loc - 1);
        quickSort(array, loc + 1, right);
    }

    /**
     * 在array中从l到r的范围内找到分界索引
     *
     * @param array 数组
     * @param l     左
     * @param r     右
     * @return 分界的索引
     */
    public int partition(int[] array, int l, int r) {
        int inL = l;
        int inR = r + 1;
        int pivot = array[l];

        /*
        从左向右遍历数组，如果某一个元素小于pivot，就继续向后遍历
        如果大于或等于，就停止遍历
        如果按序摆放，退出条件就是到末尾
         */
        while (true) {
            // 找到第一个大于pivot的左侧元素。为什么要++inL——避开第一个pivot
            while (array[++inL] < pivot) {
                if (inL == r) {
                    break;
                }
            }

            // 找到第一个小于pivot的右侧元素。为什么要--inR——inR是开区间
            while (pivot < array[--inR]) {
                if (inR == l) {
                    break;
                }
            }

            // 外层循环退出条件
            if (inL >= inR) {
                break;
            }

            // 交换这两个错序的元素
            swap(array, inL, inR);
        }

        // 把pivot放到属于他的位置，交换后的inR就是当前pivot的索引
        swap(array, l, inR);
        return inR;
    }

    /**
     * 交换s数组中的s[i]与s[j]元素
     *
     * @param s 数组
     * @param i 索引i
     * @param j 索引j
     */
    public void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
