package cn.doubleLinked;
//双向带环带头节点的链表，实战更常用。
//无头双向链表实现

class DLinkedNode{
    public  int val = 0;
    public  DLinkedNode prev = null;
    public  DLinkedNode next = null;

    public DLinkedNode(int val) {
        this.val = val;
    }
}
public class DLinkedList {
    private DLinkedNode head = null;

    public DLinkedList() {
        //创建傀儡节点
        head = new DLinkedNode(-1);
        //带环
        head.next = head;
        head.prev = head;
    }

    //头插法
    public void addFirst(int data){
        //创建一个新的节点
        DLinkedNode newNode = new DLinkedNode(data);
        DLinkedNode next = head.next;

        head.next = newNode;
        newNode.next = next;

        newNode.prev = head;
        next.prev = newNode;
    }

    //尾插法
    public void addLast(int data){
        //创建一个新的节点
        DLinkedNode newNode = new DLinkedNode(data);
        //这个节点就是新的节点的前一个节点，head就是新的节点的后一个节点
        DLinkedNode prev = head.prev;
        newNode.next = head;
        head.prev = newNode;
        prev.next = newNode;
        newNode.prev = prev;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        int size = size();
        if (index < 0 || index > size){
            return;
        }
        if (index == 0){
            //头插
            addFirst(data);
            return;
        }
        if (index == size){
            //尾插
            addLast(data);
            return;
        }
        DLinkedNode next = getPos(index);
        DLinkedNode prev = next.prev;

        DLinkedNode newNode = new DLinkedNode(data);
        prev.next = newNode;
        newNode.prev = prev;

        next.prev = newNode;
        newNode.next = next;
    }

    public DLinkedNode getPos(int index) {
        // 找到下标为 index 对应的节点
        DLinkedNode cur = head.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int toFind){
        for (DLinkedNode cur = head.next;cur != head;cur = cur.next){
            if (cur.val == toFind){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //1.先找到要删除元素的位置
        DLinkedNode toRemove = new DLinkedNode(key);
        if (toRemove == null){
            return;
        }
        //2.进行具体删除
        DLinkedNode prev = toRemove.prev;
        DLinkedNode next = toRemove.next;
        prev.next = next;
        next.prev = prev;
    }

    public DLinkedNode find(int key){
        for (DLinkedNode cur = head.next;cur != head;cur = cur.next){
            if (cur.val == key){
                return cur;
            }
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        while (true) {
           remove(key);
        }
    }

    //得到单链表的长度
    public int size(){
        int size = 0;
        for (DLinkedNode cur = head.next;cur != head;cur = cur.next){
            size++;
        }
        return size;
    }

    public void clear(){
        // clear 预期得到的是一个初始状态下的空链表
        // 对于我们当前这样的链表来说, 初始状态也
        // 带有一个傀儡节点, 傀儡节点 prev 和 next 指向自身
        head.next = head;
        head.prev = head;
    }

    //打印输出
    public void display(){
        System.out.print("正向：[");
        for (DLinkedNode cur = head.next; cur != head; cur = cur.next){
            System.out.print(cur.val);
            if (cur.next != head){
                System.out.print(",");
            }
        }
        System.out.println("]");

        System.out.print("反向：[");
        for (DLinkedNode cur = head.prev; cur != head; cur = cur.prev){
            System.out.print(cur.val);
            if (cur.prev != head){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}
