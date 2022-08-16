package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 曾睿
 * @Date: 2021/7/1 16:37
 */
public class E09回文数 {

    public static void main(String[] args) {
        System.out.println(f(0));
    }

    public static boolean f(int x){
        if(x<0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while(x != 0){
            list.add(x % 10);
            x = x / 10;
        }
        for (int i = 0; i < list.size()/2; i++) {
            if(!list.get(i).equals(list.get(list.size()-1 - i))){
                return false;
            }
        }
        return true;
    }

}
