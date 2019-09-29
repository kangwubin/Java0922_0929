package cn.LinekList;

public class LinkedTest {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
        testContains();
        testRemove();
        testRemoveAll();
    }

    public static void testAddFirst(){
        System.out.println("测试头插");
        LinkedList  list=new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
    }

    public static void testAddLast(){
        System.out.println("测试尾插");
        LinkedList  list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
    }

    public static void testAddIndex(){
        System.out.println("测试插入方法！");
        LinkedList  list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
        System.out.println("插入之后的结果：");
        list.addIndex(0,6);
        list.addIndex(2,5);
        list.addIndex(6,8);
        list.display();
    }

    public static void testContains() {
        System.out.println("测试元素是否存在链表中！");
        LinkedList  list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
        boolean result=list.contains(2);
        System.out.println("实际结果："+result);
    }

    public static void testRemove(){
        System.out.println("测试删除元素！");
        LinkedList  list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
        System.out.println("删除后：");
        list.remove(2);
        list.display();
    }
    public static void testRemoveAll(){
        System.out.println("测试所有值相同元素！");
        LinkedList  list=new LinkedList();
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(4);
        list.display();

        list.removeAllKey(1);
        list.display();
    }

}
