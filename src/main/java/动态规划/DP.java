package 动态规划;

/**
 * @Author: 曾睿
 * @Date: 2021/6/15 17:05
 */
public class DP {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,1,7,8,3};
        final int opt = rec_opt(arr, 6);
        System.out.println(opt);

    }


    /**
     * 算最大值 - 使用递归，缺点：会出现大量重叠子问题，2^n
     * @param arr
     * @param i
     * @return
     */
    public static int rec_opt(int[] arr,int i){
        // 递归跳出情况
        if(i == 0){
            return arr[0];
        }
        if(i == 1){
            return Math.max(arr[0], arr[1]);
        }
        // 其他情况：选/不选
        // 选
        int a = rec_opt(arr, i - 2) + arr[i];
        // 不选
        int b = rec_opt(arr, i - 1);
        return Math.max(a, b);
    }

    /**
     * 使用非递归的
     * @return
     */
    public static int dp_opt(int[] arr,int i){
        int[] opt = new int[arr.length];
        // 从后往前从小的开始计算
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0],arr[1]);

        for (int j = 2; j < arr.length; j++) {
            // 选
            int a = opt[j - 2] + arr[j];
            // 不选
            int b = opt[j - 1];
            opt[j] = Math.max(a, b);
        }
        return opt[arr.length - 1];
    }

}
