package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 曾睿
 * @Date: 2021/7/28 16:08
 */
public class M15三数之和 {

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 外层循环
        for (int i = 0; i < nums.length; i++) {
            // 第二层循环 --- 在相同的时候去重
            for (int j = i + 1; j < nums.length; j++) {
                // 存在两数之和，并且不是这两个
                if(map.containsKey(-nums[i] - nums[j]) && map.get(-nums[i] - nums[j]) !=i && map.get(-nums[i] - nums[j]) != j){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i] - nums[j]);
                    lists.add(list);
                }
            }
        }
        return lists.stream().distinct().collect(Collectors.toList());
    }

}
