package leetcode;

/**
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * @Author: 曾睿
 * @Date: 2021/6/23 21:45
 */
public class M2两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        ListNode l2 = new ListNode(9,new ListNode(9));
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        int flag = 0;
        while ((p1 != null || p2 != null) || flag!=0){
            int s1 = p1 == null ? 0 : p1.val;
            int s2 = p2 == null ? 0 : p2.val;
            int count;
            int s = s1 + s2 + flag;
            if(s >= 10){
                s -= 10;
                count = s;
                flag = 1;
            }else {
                count = s;
                flag = 0;
            }
            ListNode tmp = result;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new ListNode(count);

            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        result = result.next;
        return result;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
