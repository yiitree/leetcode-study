package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 曾睿
 * @Date: 2021/7/28 16:08
 */
public class M15三数之和1 {

    public static void main(String[] args) {
//        List<List<Integer>> lists = threeSum(new int[]{0,0,0,0});
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        int i = 1;
        int j = nums.length - 1;
        for (int k = 0; k < nums.length-2 && nums[k] <= 0; ) {
            while(true){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    // exit
                    if (i == j-1) {
                        i = k + 2;
                        break;
                    } else {
                        int t = i;
                        do {
                            i++;
                        } while (nums[i] == nums[t] && i < j-1);
                    }
                } else if (sum > 0) {
                    // exit
                    if (i == j-1) {
                        j = nums.length -1;
                        break;
                    } else {
                        int t = j;
                        do {
                            j--;
                        } while (nums[j] == nums[t] && i < j-1);
                    }
                } else {
                    // == 0
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                    j = nums.length -1;
                    i = k + 2;
                    break;
                }
            }
            int t = k;
            do {
                k++;
            } while (nums[k] == nums[t] && k < j-2);
        }
        return res;
    }

}
