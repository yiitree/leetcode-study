package study.数组;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class E704二分查找 {

    public static void main(String[] args) {
        int res = new E704二分查找().search(new int[]{-1,0,3,5,9,12}, 9);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int f = 0;
        int l = nums.length-1;
        int p = (f + l) / 2;
        while(p != f && p != l){
            if(target == nums[p]){
                return p;
            }
            // 左移
            if(target < nums[p]){
                l = p-1;
            }
            // 右移
            if(target > nums[p]){
                f = p+1;
            }
            p = (f + l) / 2;
        }
        if(target == nums[l]){
            return l;
        }
        if(target == nums[f]){
            return f;
        }
        return -1;
    }

}
