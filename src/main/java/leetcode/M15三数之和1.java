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
        // list<list<Integer>> lists = threeSum(new int[]{0,0,0,0});
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // i退出
            if (nums[i] > 0){
                break;
            }
            // i去重
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // 开始计算r、l
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]){
                        l++;
                    }
                    l++;
                    while (l < r && nums[r] == nums[r - 1]){
                        r--;
                    }
                    r--;
                } else if (sum < 0){
                    while (l < r && nums[l] == nums[l + 1]){
                        l++;
                    }
                    l++;
                }
                else if (sum > 0){
                    while (l < r && nums[r] == nums[r - 1]){
                        r--;
                    }
                    r--;
                }
            }
        }
        return ans;
    }

}
