package leetcode.贪心算法;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i
 * ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 *  
 * 示例 1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E455分发饼干 {

    public static void main(String[] args) {
        System.out.println(new E455分发饼干().findContentChildren(
                // 孩子
                new int[]{1,2},
                // 饼干
                new int[]{1,2,3}));
    }

//    public int findContentChildren(int[] g, int[] s) {
//        if (s.length == 0 || g.length == 0) {
//            return 0;
//        }
//        // 可以吃的饼干
//        int count = 0;
//        int result = 0;
//        Arrays.sort(g);
//        Arrays.sort(s);
//        // 孩子
//        for (int child : g) {
//            // 吃饭：还没吃饱，还有饭
//            while (child > 0 && count <= s.length - 1) {
//                // 吃一个，并移动指针，减少饭量
//                System.out.println(child +" "+ s[count]);
////                child -= s[count];
//                count++;
//            }
//            // 吃好了才统计
//            if (child <= 0) {
//                result++;
//            }
//            // 检查是否还有饼干
//            if (count > s.length - 1) {
//                return result;
//            }
//        }
//        // 孩子全部吃饱了，返回
//        return result;
//    }

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) {
            return 0;
        }
        // 可以吃的饼干
        int child = 0;
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        // 遍历饼干
        for (int i = 0; i < s.length; i++) {
            // 饼干满足条件
            if(g[child] - s[i] <= 0){
                res++;
                // 检查还有小孩吗
                if(child == g.length -1){
                    return res;
                }
                child++;
            }
        }
        return res;
    }

    public int distributeCandies(int[] candyType) {
        int count = candyType.length / 2;
        long s = Arrays.stream(candyType).distinct().count();
        return (int) Math.min(count,s);
    }

}
