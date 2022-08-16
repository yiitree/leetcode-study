package study.数组;

import java.util.Arrays;

public class M59螺旋矩阵2 {
    public static void main(String[] args) {
        int[][] res = new M59螺旋矩阵2().generateMatrix(4);
        System.out.println(Arrays.deepToString(res));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = n * n;
        // 定义边长
        int len = n;
        int row = 0;
        int rol = 0;

        int i = 0;
//        while(true){
//            i++;
//            // 右
//            for (int i = 0; i < len; i++) {
//                res[i][row] = i;
//            }
//
//            // 下
//
//
//            // 左
//
//            // 上
//        }


        return res;
    }
}
