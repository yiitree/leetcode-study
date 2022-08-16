package leetcode.动态规划;

/**
 * @Author: 曾睿
 * @Date: 2021/6/15 22:20
 */
public class DP2 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(rec_subset(arr, arr.length-1, 13));
    }

    public static boolean rec_subset(int[] arr,int i,int s){
        if(s == 0){
            return true;
        }
        if (i == 0){
            return arr[0] == s;
        }
        if(arr[i] > s){
            return rec_subset(arr, i - 1, s);
        }
        boolean a = rec_subset(arr, i - 1, s - arr[i]);
        boolean b = rec_subset(arr, i - 1, s);
        return a || b;
    }

}
