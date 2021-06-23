import java.util.ArrayList;
import java.util.List;

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
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3,new ListNode(5))));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        addTwoNumbers(l1, l2).forEach(System.out::println);
    }

    public static List<Integer> addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        List<Integer> list = new ArrayList<>();
        int tmp = 0;
        while (p1 != null || p2 != null){
            int s1 = p1 == null ? 0 : p1.val;
            int s2 = p2 == null ? 0 : p2.val;
            int count;
            int s = s1 + s2;
            if(s >= 10){
                s -= 10;
                count = s + tmp;
                tmp = 1;
            }else {
                count = s + tmp;
                tmp = 0;
            }
            list.add(count);
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        return list;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
