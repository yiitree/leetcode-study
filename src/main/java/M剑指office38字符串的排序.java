import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 曾睿
 * @Date: 2021/6/22 22:46
 */
public class M剑指office38字符串的排序 {
    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }




    /**
     * 取值，第一次去第一个值，然后把改值去掉
     * @param s
     * @return
     */
    public static String[] permutation(String s) {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(s);
        // 第一个字母按照顺序，剩下的就从头开始取
        for (int m = 0; m < s.length(); m++) {
            // 第一个字母的
            StringBuilder newStr = new StringBuilder();
            char c = stringBuilder.charAt(m);
            stringBuilder.deleteCharAt(0);
            newStr.append(c);
            // 剩下字母一直从第一个开始取
            while (stringBuilder.charAt(0) == 32){
                for (int n = 0; n < s.length(); n++) {
                    c = stringBuilder.charAt(n);
                    stringBuilder.deleteCharAt(0);
                    newStr.append(c);
                }
            }
        list.add(newStr);
        }
        return list.toArray(new String[list.size()-1]);
    }





//    /**
//     * 取值，第一次去第一个值，然后把改值去掉
//     * @param s
//     * @return
//     */
//    public static String[] permutation(String s) {
//        int len = 1;
//        for (int i = s.length(); i > 0; i--) {
//            len *= i;
//        }
//
//        String[] strings = new String[len];
//
//        StringBuilder stringBuilder = new StringBuilder(s);
//        char[] chars = s.toCharArray();
//        // 一共有6中结果
//        for (int i = 0; i < len; i++) {
//            // 第一个结果
//            StringBuilder newStr = new StringBuilder();
//
//            // 第一位数，一共有三位数，要循环三次
//            for (int m = 0; m < s.length(); m++) {
//                for (int n = 0; n < s.length(); n++) {
//                    // 第一位数字
//                    char c = stringBuilder.charAt(n);
//                    newStr.append(c);
//                }
//            }
//            strings[i] = newStr.toString();
//
//
//
//
//
//            // 把每一个结果进行填充
//            // 第一个结果
//            while (chars[chars.length - 1] == 32){
//
//
//
//                // 每个结果的每一个数字
//                for (int j = i; j < s.length(); j++) {
//                    // 第一位数字
//                    char c = stringBuilder.charAt(j);
//                    newStr.append(c);
//
//
//                }
//
//
//            }
//
//            strings[i] = "";
//        }
//        return strings;
//    }

//    public static String[] permutation(String s) {
//
//        // 结果的长度
//
//        int len = 1;
//        //
//        for (int i = s.length(); i > 0; i--) {
//            len *= i;
//        }
//        String[] strings = new String[len];
//
//
//        for (int j = 0; j < len; j++) {
//
//            // 第一个数字
//            char[] chars = new char[s.length()-1];
//            // 循环第一个字母
//            for (int i = 0; i < s.length(); i++) {
//                // 第i个字母
//                char c = s.charAt(i);
//                chars[i] = c;
//
//                // 循环第2个
//                for (int k = 0; k < ; k++) {
//
//                }
//
//            }
//
//
//        }
//
//
//
//
//
//
//
//    }

}
