import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: 曾睿
 * @Date: 2021/6/30 22:45
 */
public class M03无重复字符的最长子串 {



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)) return 0;
        StringBuilder sb = new StringBuilder(s);

        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < sb.length(); i++) {
            String pi = s.substring(i, i);
            for (int j = i+1; j <s.length()-i; j++) {
                char pj = s.charAt(j);
                if(pi == pj){
                    list.add(result);
                    break;
                }

                result++;
            }
        }
        return list.stream().max(Comparator.comparingInt(x -> x)).get();
    }
}
