package bfs1dfs;

import java.util.*;

/**
 * add() --- boolean
 * push() --- 添加的值
 *
 * peek() --- 获取不弹出
 * pop() --- 获取并弹出
 */
public class DFS {

    public static void main(String[] args) {
        HashMap<String,String[]> graph = new HashMap<>();
        graph.put("A", new String[]{"B", "C"});
        graph.put("B",new String[]{"A","C","D"});
        graph.put("C",new String[]{"A","B","D","E"});
        graph.put("D",new String[]{"B","C","E","F"});
        graph.put("E",new String[]{"C","D"});
        graph.put("F",new String[]{"D"});
        bfs(graph, "A");

    }

    /**
     * DFS深度优先
     * @param graph
     * @param start
     * @return
     */
    static void bfs(HashMap<String,String []> graph, String start){
        // 定义一个临时遍历集，用于标记哪些节点已经别访问过了
        HashSet<String> seen = new HashSet<>();
        seen.add(start);
        // 定义一个队列。表示每一个节点的子节点
        Stack<String> stack = new Stack<>();
        stack.push(start);
        // 栈还有元素
        while(stack.size()>0){
            // 取出栈中上面的元素
            String pop = stack.pop();
            // 找到此元素的子元素
            String[] strings = graph.get(pop);
            // 遍历栈中元素，再次添加
            for (String string : strings) {
                // 如果已经事先添加过的就不再次添加了
                if(!seen.contains(string)){
                    seen.add(string);
                    stack.push(string);
                }
            }
            System.out.print(pop);
        }
    }

}
