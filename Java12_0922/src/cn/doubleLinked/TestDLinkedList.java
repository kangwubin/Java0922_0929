package cn.doubleLinked;

public class TestDLinkedList {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
    }

    public static void testAddFirst(){
        System.out.println("测试双向链表的头插：");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addFirst(1);
        dLinkedList.addFirst(2);
        dLinkedList.addFirst(3);
        dLinkedList.addFirst(4);
        dLinkedList.display();
    }

    public static void testAddLast(){
        System.out.println("测试双向链表的尾插：");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.display();
    }
}
