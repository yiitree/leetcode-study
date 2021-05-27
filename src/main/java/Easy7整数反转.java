import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 曾睿
 * @Date: 2021/5/27 22:14
 */
public class Easy7整数反转 {

    public int reverse(int x) {
        //范围最大值
        int max = (int) Math.pow(2,31)-1;
        //范围最小值
        int min = (int) -Math.pow(2,31);

        List<Integer> list = new ArrayList<>();
        int result = 0;
        long m = 1;
        while (x / m != 0){
            list.add(Math.toIntExact((x / m) % 10));
            m *= 10;
        }
        for (int i = 0; i < list.size(); i++) {
            result += (list.get(i)) * Math.pow(10, list.size()-i-1);
        }
        result = result >= max ? 0 : result;
        result = result <= min ? 0 : result;
        return result;
    }

}
