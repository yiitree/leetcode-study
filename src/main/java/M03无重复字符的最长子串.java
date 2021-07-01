import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 曾睿
 * @Date: 2021/6/30 22:45
 */
public class M03无重复字符的最长子串 {



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba") == 2);
        System.out.println(lengthOfLongestSubstring1("abcabcbb") == 3);
        System.out.println(lengthOfLongestSubstring1("bbbbb") == 1);
        System.out.println(lengthOfLongestSubstring1("pwwkew") == 3);
        System.out.println(lengthOfLongestSubstring1("au") == 2);
    }

    /**
     * 暴力循环
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)) return 0;
        if(s.length() == 1) return 1;
        int max = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <s.length(); j++) {
                String pi = s.substring(i, j);
                String pj = s.substring(j, j+1);
                if(pi.contains(pj)){
                    i = s.indexOf(pi);
                    max = Math.max(max, result + 1);
                    result = 0;
                    break;
                }
                if(s.length()-1 == j){
                    max = Math.max(max, s.length()-i);;
                }
                result++;
            }
        }
        return max;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
//        if("".equals(s)) return 0;
//        if(s.length() == 1) return 1;

        HashMap<Character, Integer> map = new HashMap<>();

        int result = 0;

        // 前指针
        int start = 0;
        char startStr = s.charAt(start);
        // 后指针
        for (int end = 0; end < s.length(); end++) {
            char endStr = s.charAt(end);
            // 说明有重复
            if(map.containsKey(endStr)){
                // 把前指针移动到重复位置
                start = Math.max(map.get(endStr)+ 1, start);
            }
            // 记录最大的长度
            result = Math.max(result, end - start+1);
            map.put(endStr, end);
        }
        return result;




    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

}
