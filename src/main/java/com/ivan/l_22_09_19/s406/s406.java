package com.ivan.l_22_09_19.s406;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Maximilian_Li
 */
public class s406 {
    /**
     * 假设有打乱顺序的一群人站成一个队列，每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     * <p>
     * 请你重新构造并返回输入数组people 所表示的队列。
     *
     * @param people 数组 people 表示队列中一些人的属性（不一定按顺序）
     * @return 返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     */
    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        LinkedList<int[]> queue = new LinkedList<>();

        // 按照身高从高到低将people排序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[length][]);
    }
}
