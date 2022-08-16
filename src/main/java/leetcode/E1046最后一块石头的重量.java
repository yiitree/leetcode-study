package leetcode;

import java.util.PriorityQueue;

/**
 * @Author: 曾睿
 * @Date: 2021/6/9 09:01
 */
public class E1046最后一块石头的重量 {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{3,7,2}));
    }

    public static int lastStoneWeight(int[] stones) {
        /*
        if(stones.length == 1){
            return stones[0];
        }
        if(stones.length == 2){
            return Math.abs(stones[0] - stones[1]);
        }
        int s;
        while(true){
            Arrays.sort(stones);
            if(stones[stones.length - 2] == 0){
                s = stones[stones.length - 1];
                break;
            }
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
        }
        return s;
        */

        /*
        Arrays.sort(stones);
        int len = stones.length - 1;
        for (int i = len; i > 0; i--) {
            stones[len] = stones[len] - stones[len - 1];
            stones[len - 1] = 0;
            Arrays.sort(stones);
        }
        return stones[len];
         */

        // 最大顶针队列，其实就是会添加的时候自动排序。
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();

    }

}

