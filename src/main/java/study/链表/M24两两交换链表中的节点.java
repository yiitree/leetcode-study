package study.链表;


/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 */
public class M24两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode res = new M24两两交换链表中的节点().swapPairs(listNode1);

        System.out.println(res);
    }

    public ListNode swapPairs(ListNode head) {
        // 单链表直接返回
        if(head == null || head.next == null){
            return head;
        }
        // 设置哨兵
        ListNode h = new ListNode(0, head);
        ListNode p = h;

        while (p.next != null && p.next.next != null){
            ListNode p1 = p.next;
            ListNode p2 = p.next.next;
            ListNode tmp = p.next.next.next;

            p.next = p2;
            p2.next = p1;
            p1.next = tmp;

            p = p.next.next;
        }


        return h.next;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}