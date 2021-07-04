/**
 * @Author: 曾睿
 * @Date: 2021/7/3 10:04
 */
public class M04 {

    public static void main(String[] args) {
//        System.out.println( f(new int[]{1,2}, new int[]{3,4}) == 2.5 );
        System.out.println( f(new int[]{1,2}, new int[]{3,4,5}) == 3);


    }

    public static float f(int[] ai, int[] bi){
        int[] a;
        int[] b;
        if(ai.length <= bi.length){
            a = ai;
            b = bi;
        }else {
            a = bi;
            b = ai;
        }

        int n = a.length + b.length;
        int ap = 0;
        int bp = 0;
        int[] res = new int[2];
        for (int i = 1; i < n/2 +1; ) {

            if(i == n/2){
                res[0] = Math.min(a[ap], b[bp]);
            }
            // 取两个中最小的
            if(a[ap] <= b[bp]){
                ap++;
                i++;
            }else {
                bp++;
                i++;
            }

            // 检查是否超出，超出后转移到另一个数组
            if(ap > a.length-1){
                if(b.length%2==0){
                    // 偶数,取值为  n/2-1  n/2
                    return (b[b.length / 2 - 1] + res[0]) / 2.0f;
                }else {
                    // 奇数 n/2
                    return b[b.length / 2];
                }
            }

        }


        res[1] = Math.min(a[ap], b[bp]);
        if(n%2==0){
            // 偶数,取值为  n/2-1  n/2
            return (res[0] + res[1]) / 2.0f;

        }else {
            // 奇数 n/2
            return res[1];
        }
    }
}
