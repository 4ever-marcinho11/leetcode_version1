package com.ivan.l_22_09_05.s93;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效的IP地址正好由四个整数（每个整数位于0到255之间组成，且不能含有前导 0）
 * 整数之间用 '.' 分隔。
 *
 * @author Maximilian_Li
 */
public class s93 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {

        bt(s, 0, 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param s       字符串
     * @param start   起始索引
     * @param partNum 已有分段数目
     */
    public void bt(String s, int start, int partNum) {
        if (s.length() == start && partNum == 4) {
            // 遍历完 + 正好四段
            res.add(path.toString());
            return;
        }

        if (s.length() == start || partNum == 4) {
            return;
        }

        for (
                int i = start;
                i < s.length() &&
                        // 一段长度最大为3
                        i - start < 3 &&
                        // 0 <= x <= 255
                        Integer.parseInt(s.substring(start, i + 1)) >= 0 &&
                        Integer.parseInt(s.substring(start, i + 1)) <= 255;
                i++
        ) {
            if (i - start > 0 && s.charAt(start) == '0') {
                continue;
            }
            path.append(s, start, i + 1);
            if (partNum < 3) {
                // 已分三段已经有了三个.，就不用再加.l
                path.append(".");
            }
            partNum++;
            bt(s, i + 1, partNum);
            path.delete(start + partNum, i + partNum + 2);
            partNum--;
        }
    }
}
