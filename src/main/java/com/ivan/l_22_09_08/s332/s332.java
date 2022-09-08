package com.ivan.l_22_09_08.s332;

import java.util.*;

/**
 * @author Maximilian_Li
 */
public class s332 {
    LinkedList<String> res = new LinkedList<>();
    /**
     * 记录航班的映射关系，integer>0就代表该行程可以被遍历到
     */
    HashMap<String, Map<String, Integer>> mapper = new HashMap<>();

    /**
     * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
     * <p>
     * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
     * <p>
     * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
     * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
     *
     * @param tickets 航线列表
     * @return 规划后的行程
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // 初始化targets
        for (List<String> t : tickets) {
            // 起点
            String src = t.get(0);
            // 终点
            String des = t.get(1);
            // mapper中对应的子映射表
            Map<String, Integer> temp;

            if (mapper.containsKey(src)) {
                // 已经有从src机场起飞的航班了
                temp = mapper.get(src);
                temp.put(des, temp.getOrDefault(des, 0) + 1);
            } else {
                // TreeMap是一个升序map
                temp = new TreeMap<>();
                temp.put(des, 1);
            }
            mapper.put(src, temp);
        }

        res.add("JFK");
        bt(tickets.size());
        return res;
    }

    /**
     * 只需要找到一个行程顺序即可，因此返回boolean
     *
     * @param ticketNum 机票数量
     * @return boolean
     */
    public boolean bt(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }

        // 得到目前行程中最后一个机场
        String lastDest = res.getLast();
        if (mapper.containsKey(lastDest)) {
            // 最后一个机场还可以作为始发地的话
            Map<String, Integer> key = mapper.get(lastDest);
            for (Map.Entry<String, Integer> e : key.entrySet()) {
                int count = e.getValue();
                if (count > 0) {
                    // 在这里回溯
                    res.add(e.getKey());
                    e.setValue(count - 1);
                    if (bt(ticketNum)) {
                        return true;
                    }
                    res.removeLast();
                    e.setValue(count);
                }
            }
        }
        return false;
    }
}
