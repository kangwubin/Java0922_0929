package cn.practice;

public class Solution {
    //1.删除链表中等于给定值 **val** 的所有节点。
    public ListNode removeElements(ListNode head, int val) {
        //判断是否为空
<<<<<<< HEAD
        if(head == null){
            return null;
        }
        //1.先删除非头节点
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                //要删除的节点
                prev.next = cur.next;
                cur = prev.next;
=======
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
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
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

<<<<<<< HEAD
    //2.反转一个单链表=链表匿置(重点)
    public ListNode reverseList(ListNode head) {
        //对于空链表，不需要任何处理
        if (head == null){
=======
    //2.反转一个单链表(重点)
    public ListNode reverseList(ListNode head) {
        //对于空链表，不需要任何处理
        if(head == null){
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
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
<<<<<<< HEAD
                //cur指向最后一个节点了
                newHead = cur;
            }
            cur.next = prev;
=======
               newHead = cur;
            }
            //翻转指针的指向
            cur.next = prev;
            //更新prev和cur
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    //3.给定一个带有头结点head的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode(ListNode head) {
        //得到链表的长度
<<<<<<< HEAD
          int steps = size(head) / 2;
         //根据长度的一半移动cur
        ListNode cur = head;
        for (int i = 0;i < steps;i++){
=======
         int steps = size(head) / 2;
         //根据长度的一半移动cur
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
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
<<<<<<< HEAD
        if (head == null || k <= 0 || k >length){
=======
        if (head == null || k <= 0 || k >length ){
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
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

<<<<<<< HEAD
    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。(重点)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判断为空
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        //
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = null;
        ListNode newTail = null;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                // 新链表是空链表
                if (newHead == null){
                newHead = cur1;
                newTail = cur1;
                cur1 = cur1.next;
                }else {
                    // 新链表不是空链表
                    newTail.next = cur1;
                    // 更新尾部的指向.
                    newTail = newTail.next;
                    cur1 = cur1.next;
                }
            }else {
                // 就把 cur2 指向的节点插入到新链表的尾部
                if (newHead == null){
                    // 新链表是空链表
                    newHead = cur2;
                    newTail = cur2;
                    cur2 = cur2.next;
                }else {
                    // 新链表不是空链表
                    newTail.next = cur2;
                    // 更新尾部的指向.
                    newTail = newTail.next;
                    cur2 = cur2.next;
                }
            }
        }
        // 如何判定当前哪个链表到达结尾, 哪个链表还有剩余?
        if (cur1 == null){
            // cur2 还有剩余
            newTail.next = cur2;
        }
        if (cur2 == null){
            // cur1 还有剩余
            newTail.next = cur1;
        }
        return newHead;
    }

    //6.编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前给定一个链表的头指针 ListNode* pHead，
    // 请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
    public ListNode partition(ListNode pHead, int x) {
        // 没有元素
        if (pHead == null){
            return null;
        }
        // 只有一个元素
        if (pHead.next == null){
            return pHead;
        }
        //创建傀儡节点
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bijHead = new ListNode(-1);
        ListNode bigTail = bijHead;
        for (ListNode cur = pHead;cur != null;cur = cur.next){
            if (cur.val < x){
                // 插入到 smallTail 之后
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else {
                // 插入到 bigTail 之后
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bijHead.next;
        return smallHead.next;
    }

    //7.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        //创建新链表
        ListNode newHead = new ListNode(-1);
        ListNode newTail =newHead;
        //创建当前节点
        ListNode cur = pHead;
        while (cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                // 说明 cur 指向的位置已经是重复的节点了
                // 继续往后找 cur, 找到那个不重复的节点的位置
                // 这样做是为了把若干个相同的节点都跳过去
                while (cur != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                // 循环结束, cur 指向的是这片重复元素的最后一个
                // 再多走一步, cur 指向的就是不重复的元素了
                cur = cur.next;
            }else {
                // 当前这个节点不是重复节点
                // 就把这个节点插入到新链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
            }
        }
        return newHead.next;
    }

    //8.对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    //测试样例：1->2->2->1;返回：true
    public boolean chkPalindrome(ListNode A) {
        // 此处只是假设算回文
        if (A == null){
            return true;
        }
        // 只有一个元素, 就是回文
        if (A.next == null){
            return true;
        }
        //找中间节点
        int lenA = size(A);
        int steps = lenA / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 使用 B 指向新链表的头部
                B = cur;
            }
            cur.next = prev;
            // 更新 prev, 更新 cur
            prev = cur;
            cur = next;
        }
        // 3. 对比两个链表内容是否相同
        while (B != null) {
            if (A.val != B.val) {
                // 对应元素不相等, 一定不是回文
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    //9.输入两个链表，找出它们的第一个公共结点.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 分别求两个链表的长度
            int lenA = size(headA);
            int lenB = size(headB);
        // 2. 让长的链表先走长度的差值步
            if (lenA > lenB){
                int offset = lenA - lenB;
                for (int i = 0; i < offset; i++) {
                    headA = headA.next;
                }
            }else {
                int offset =lenB - lenA;
                for (int i = 0; i < offset; i++) {
                    headB = headB.next;
                }
            }
        // 3. 分别让两个链表的节点同时移动, 比较节点是否是相同节点
           while (headA != null && headB != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
           }
           return null;
    }

    //10.给定一个链表，判断链表中是否有环（重点）。时间复杂度：O(N);空间复杂度：O(1)
    /*基本思路：快慢指针：快指针一次走两步，慢指针一次走一步
    1.如果链表不带环，快指针一定先到达末尾；如果链表带环，快指针一定会和慢指针重合。
    2.在使用快慢指针时：如果快慢指针的速度差值是1，可以重合，否则就不行。
    * */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        //创建快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    //11.给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        //核心：从链表头部出发, 到入口点的距离,和从快慢指针的交汇处出发, 到入口点的距离相等.
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            //快指针走两步
            fast = fast.next.next;
            //慢指针走一步
            slow = slow.next;
            //比较对象的身份
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null){
            //不带环
            return null;
        }
        // 循环结束之后, fast 和 slow 就已经重合了
       ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
=======
    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//    }
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3

}
