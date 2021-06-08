import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * @Author: 曾睿
 * @Date: 2021/6/8 09:43
 */
public class M1049最后一块石头的重量2 {

    public static int lastStoneWeightII(int[] stones) {
        // 排序
        final int[] tmp = Arrays.stream(stones).sorted().toArray();
        int tV;
        for (int i = tmp.length - 1; i >= 1; i--) {
            tV = tmp[i];
            tmp[i - 1] = Math.abs(tV - tmp[i - 1]);
        }
        return tmp[0];
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{31,26,33,21,40}));
    }

}
