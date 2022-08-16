package leetcode.贪心算法;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *  
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M53最大子数组和 {

    public static void main(String[] args) {
        System.out.println("res = " +
                new M53最大子数组和().maxSubArray(
                        new int[]{0,3,-1}
                                              ));
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if(tmp < 0){
                if(res < tmp){
                    res = tmp;
                }
                continue;
            }

            int j = i+1;

            while(j < nums.length){
                tmp += nums[j];
                if(tmp < 0){
                    break;
                }
                j++;
                if(res < tmp){
                    res = tmp;
                }
            }
            i = j;
        }
        return res;
    }

}
