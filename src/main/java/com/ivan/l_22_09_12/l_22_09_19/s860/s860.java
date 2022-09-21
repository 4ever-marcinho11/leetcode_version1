package com.ivan.l_22_09_12.l_22_09_19.s860;

/**
 * @author Maximilian_Li
 */
public class s860 {
    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品.
     * （按账单 bills 支付的顺序）一次购买一杯。
     * <p>
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * <p>
     * 注意，一开始你手头没有任何零钱。
     *
     * @param bills 整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
     * @return 如果你能给每位顾客正确找零，返回true ，否则返回 false。
     */
    public boolean lemonadeChange(int[] bills) {
        int numOf5 = 0, numOf10 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                numOf5++;
            } else if (bill == 10) {
                if (numOf5 > 0) {
                    numOf5--;
                } else {
                    return false;
                }
                numOf10++;
            } else {
                if (numOf5 > 0 && numOf10 > 0) {
                    numOf5--;
                    numOf10--;
                } else if (numOf10 == 0 && numOf5 >= 3) {
                    numOf5 -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
