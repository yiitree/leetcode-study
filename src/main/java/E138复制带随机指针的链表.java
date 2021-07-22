import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 曾睿
 * @Date: 2021/7/1 16:37
 */
public class E138复制带随机指针的链表 {

    public static void main(String[] args) {

        Node node4 = new Node(1,null,null);
        Node node3 = new Node(10,node4,null);
        Node node2 = new Node(11,node3,null);
        Node node1 = new Node(13,node2,null);
        Node node = new Node(7,node1,null);

        node1.random = node;
        node2.random = node4;
        node3.random = node2;
        node4.random = node;

        copyRandomList1(node);

    }

    public static Node copyRandomList1(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node r = head;
        // 先把所有的新旧node保存到map中 k:旧  v:新
        while(head != null){
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            head = head.next;
        }
        // 遍历map，单独设置next和random
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node oldNode = entry.getKey();
            Node newNode = map.get(oldNode);
            newNode.next = map.get(oldNode.next);
            newNode.random = map.get(oldNode.random);
        }
        return map.get(r);
    }


    /**
     * 报错，，，
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        // 新节点
        Node newNode = new Node(head.val);
        map.put(newNode.val, newNode);
        // 新节点指针
        Node newNodePoint = newNode;
        while (head != null){

            Node next = null;
            Node random;
            // 下一个节点
            if(head.next != null){
                next = new Node(head.next.val);
                map.put(head.next.val,next);
                newNodePoint.next = map.get(head.next.val);
            }
            // 随机节点
            if(head.random != null){
                random = new Node(head.random.val);
                map.put(head.random.val,random);
                newNodePoint.random = map.get(head.random.val);
            }
            // 新节点的指针
            newNodePoint = next;
            // 原始节点下移
            head = head.next;
        }
        return newNode;
    }
}

class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int val,Node next ,Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
