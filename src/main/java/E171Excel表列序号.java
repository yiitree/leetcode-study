/**
 * @Author: 曾睿
 * @Date: 2021/7/30 09:45
 */
public class E171Excel表列序号 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }

    public static int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            // 十位数 * 进制 + 个位数
            ans = ans * 26 + num;
        }
        return ans;
    }
}
