package cn.practice;

public class Solution {
    //1.删除链表中等于给定值 **val** 的所有节点。
    public ListNode removeElements(ListNode head, int val) {
        //判断是否为空
        if(head==null){
            return null;
        }
        //1.先删除非头节点
        ListNode prev=head;
        ListNode cur=head.next;
        while(cur != null){
            if(cur.val==val){
                //要删除的节点
                prev.next=cur.next;
                cur=prev.next;
            }else{
                //cur对应的节点不用删
                prev = cur;
                cur = cur.next;
            }
        }
        //2.再处理头节点
        if (head.val == val){
            head = head.next;
        }
        return head;
    }

    //2.反转一个单链表(重点)
    public ListNode reverseList(ListNode head) {
        //对于空链表，不需要任何处理
        if(head == null){
            return null;
        }
        //对于只有一个元素的列表，也不要处理
        if (head.next == null){
            return head;
        }
        //对于多个节点，始终保持prev在cur之前
        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            if (next == null){
               newHead = cur;
            }
            //翻转指针的指向
            cur.next = prev;
            //更新prev和cur
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    //3.给定一个带有头结点head的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode(ListNode head) {
        //得到链表的长度
         int steps = size(head) / 2;
         //根据长度的一半移动cur
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //计算链表的长度
    public int size(ListNode head){
        int size = 0;
        //遍历链表，获取长度
        for (ListNode cur = head;cur != null;cur = cur.next) {
            size++;
        }
        return size;
    }

    //4.输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        int length = size(head);
        //判断是否非法
        if (head == null || k <= 0 || k >length ){
            return null;
        }
        //用（length - k)即为从前往后数第几个，然后让指针从前往后走几步
        int offset = length - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//    }

}
