package leetcode.贪心算法;

import java.util.Arrays;

/**
 * @Author: 曾睿
 * @Date: 2021/7/2 09:52
 */
public class M1833雪糕的最大数量 {

    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1,3,2,4,1},1));
    }

    public static int maxIceCream(int[] costs, int coins) {
        int res = 0;
        Arrays.sort(costs);
        for (int anInt : costs) {
            coins -= anInt;
            if(coins<0) {
                break;
            }
            res++;
        }
        return res;
    }

}
