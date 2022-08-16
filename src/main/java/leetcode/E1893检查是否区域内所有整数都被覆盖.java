package leetcode;

/**
 * @Author: 曾睿
 * @Date: 2021/7/23 10:11
 */
public class E1893检查是否区域内所有整数都被覆盖 {


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 50}};

        System.out.println(isCovered(arr,1,50));

    }


    public static boolean isCovered(int[][] ranges, int left, int right) {
        // 合并数组
        int[] arr = new int[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                // 合并数组，合并后的结果+1
                arr[i] += 1;
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] -= 1;
            if(arr[i] < 0){
                return false;
            }
        }
        return true;
    }


}
