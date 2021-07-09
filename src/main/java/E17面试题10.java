import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: 曾睿
 * @Date: 2021/7/9 09:54
 */
public class E17面试题10 {

    public static void main(String[] args) {
        System.out.println(majorityElement2(new int[]{1,2,2,3,3}));
    }

    public static int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if(Objects.isNull(integer)){
                map.put(num,1);
            }else {
                map.put(num,integer+1);
                if(integer+1>=(nums.length)/2+1){
                    return num;
                }
            }
        }
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        //摩尔投票法,规定计数与候选人
        int count=1,candidate=nums[0];
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(candidate==nums[i]) count++;
            else{
                count--;
                //为零则重置可能出现超过一半的数字
                if(count==0) {
                    candidate=nums[i];
                    count=1;
                }
            }
        }
        //验证，因为没说一定有众数，所以需要验证
        int x=0;
        for(int num:nums){
            if(num==candidate) x++;
        }
        return x>nums.length/2?candidate:-1;
    }

}
