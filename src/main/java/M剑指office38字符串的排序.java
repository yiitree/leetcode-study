import java.util.*;

/**
 * @Author: 曾睿
 * @Date: 2021/6/22 22:46
 */
public class M剑指office38字符串的排序 {
    public static void main(String[] args) {
        new M剑指office38字符串的排序().permutation("123");
//        for (Object o : permutation("123")) {
//            System.out.println(o);
//        }
//        Arrays.stream(permutation("123")).forEach(System.out::println);
    }


//    /**
//     //     * 取值，第一次去第一个值，然后把改值去掉
//     //     * @param s
//     //     * @return
//     //     */
//    public static Object[] permutation(String s) {
//            ss(s);
//        return null;
//    }
//
//
//
//    public static String dfs (String s,int index){
//        StringBuilder stringBuilder = new StringBuilder(s);
//        c = stringBuilder.charAt(index);
//        stringBuilder.deleteCharAt(index);
//        return stringBuilder.toString();
//    }
//
//    static char c;
//    public static List<StringBuilder> list = new ArrayList<>();
//    public static StringBuilder stringBuilder = new StringBuilder();
//    public static String dfs;
//
//    public static void ss(String s){
//        for (int m = 0; m < s.length(); m++) {
//            dfs = dfs(s,m);
//            stringBuilder.append(c);
//        }
//    }









    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    /**
     * 深度优先搜索（回溯法）
     * @param x
     */
    void dfs(int x) {
        // 搜索完毕 只有一个字母，直接返回
        if(x == c.length - 1) {
            // 添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if(set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

//
//
//    /**
//     * 取值，第一次去第一个值，然后把改值去掉
//     * @param s
//     * @return
//     */
//    public static Object[] permutation(String s) {
//        List<Map<Integer,Character>> list = new ArrayList<>();
//        // 第一个字母按照顺序，剩下的就从头开始取
//        for (int m = 0; m < s.length(); m++) {
//            // 把第m个字母放在第一位
//            for (int i = 0; i < s.length(); i++) {
//                StringBuilder stringBuilder = new StringBuilder(s);
//                Map<Integer,Character> newStr = new HashMap<>(s.length());
//                newStr.put(i, stringBuilder.charAt(m));
//                stringBuilder.deleteCharAt(m);
//                // 剩下字母一直从第一个开始取
//                for (int j = 0; j < s.length()-1; j++) {
//                    if(j >= i){
//                        newStr.put(j+1,stringBuilder.charAt(0));
//                    }else {
//                        newStr.put(j,stringBuilder.charAt(0));
//                    }
//                    stringBuilder.deleteCharAt(0);
//                }
//                list.add(newStr);
//            }
//        }
//        List<StringBuilder> ss = new ArrayList<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        list.forEach(l->{
//            l.keySet().forEach(
//                    c ->{
//                        stringBuilder.append(l.get(c));
//                        ss.add(stringBuilder);
//                    });
//
//        });
//        Object[] as = ss.stream().distinct().toArray();
//        return as;
//    }



//    /**
//     * 取值，第一次去第一个值，然后把改值去掉
//     * @param s
//     * @return
//     */
//    public static StringBuilder[] permutation(String s) {
//        int len = 1;
//        for (int i = s.length(); i > 0; i--) {
//            len *= i;
//        }
//        List<StringBuilder> list = new ArrayList<>();
//        // 第一个字母按照顺序，剩下的就从头开始取
//        for (int m = 0; m < s.length(); m++) {
//            StringBuilder stringBuilder = new StringBuilder(s);
//            // 第一个字母的
//            StringBuilder newStr = new StringBuilder();
////            for (int i = 0; i <len; i++) {
//                newStr.append(stringBuilder.charAt(m));
//                stringBuilder.deleteCharAt(m);
//                // 剩下字母一直从第一个开始取
//                while (!"".equals(stringBuilder.toString())){
//                    newStr.append(stringBuilder.charAt(0));
//                    stringBuilder.deleteCharAt(0);
////                for (int n = 0; n < s.length(); n++) {
////                    char c = stringBuilder.charAt(n);
////                    newStr.append(c);
////                    stringBuilder.deleteCharAt(0);
////                }
////                }
//                list.add(newStr);
//            }
//        }
//        return list.toArray(new StringBuilder[0]);
//    }





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
