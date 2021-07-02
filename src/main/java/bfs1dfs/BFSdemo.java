package bfs1dfs;

import java.util.*;

/**
 * @Author: 曾睿
 * @Date: 2021/7/2 17:08
 */
public class BFSdemo {

    public static void main(String[] args) {
        HashMap<String,String[]> graph = new HashMap<>();
        graph.put("A", new String[]{"B", "C"});
        graph.put("B",new String[]{"A","C","D"});
        graph.put("C",new String[]{"A","B","D","E"});
        graph.put("D",new String[]{"B","C","E","F"});
        graph.put("E",new String[]{"C","D"});
        graph.put("F",new String[]{"D"});
        BFS_Imp3(graph,"E");
    }

    /**
     * BFS广度优先
     * @param graph
     * @param start
     */
    public static void BFS_Imp3(Map<String,String[]> graph, String start){
        HashMap<String, String> parent = new HashMap<>();

        PriorityQueue<String> queue = new PriorityQueue<>();
        // 优先队列

//        queue.add(start,10);
        HashSet<String> seen = new HashSet<>();
        seen.add(start);
        parent.put(start, null);
        while (queue.size() > 0){
            String vertex = queue.poll();
            String[] nodes = graph.get(vertex);
            for (String w:nodes) {
                //如果w不在seen中
                if (seen.add(w)){
                    queue.add(w);
                    parent.put(w, vertex);
                }
            }
            System.out.print(vertex);
        }
    }
}
