package cn.LinekList;

class LinkedNode{
    public int data = 0;
    //下一个元素的位置
    public LinkedNode  next = null;

    public LinkedNode(int data) {
        this.data = data;
    }

//    public void setNext(LinkedNode next) {
//        this.next = next;
//    }
}

//面试常考点
public class LinkedList {
    //链表的头节点，根据头节点，就可以根据next把所有的剩下的元素都获取到
    private LinkedNode head = null;

    //头插法---O(1)
    public void addFirst(int elem){
        //先创建一个节点，这个节点的值为elem
        LinkedNode node = new LinkedNode(elem);
        if (this.head==null){
            this.head=node;
            return;
        }
        //如果不是空节点，就需要把新的节点放到链表的开始位置;node为新节点
//        node.setNext(head);
        node.next=head;
        this.head=node;
        return;
    }

    //尾插法---O(N)
    public void addLast(int elem){
        //创建节点
        LinkedNode node=new LinkedNode(elem);
        //如果是空链表，直接把这个节点放上去
        if (this.head==null){
            this.head=node;
            return;
        }
        //非空，需要先找到最后一个节点
        LinkedNode cur=this.head;
        //这个循环结束，cur就是最后一个节点
        while (cur.next!=null){
            cur=cur.next;
        }
        //循环结束，cur指向最后一个节点
        cur.next=node;
    }

    //任意位置插入,第一个数据节点为0号下标---O(N)
    public void addIndex(int index,int elem){
        //创建节点
        LinkedNode node=new LinkedNode(elem);
        //先进行合法校验，需要知道链表的长度
        int len=size();
        if (index < 0 || index >len){
            return;
        }
        //处理头插
        if (index == 0){
            addFirst(elem);
            return;
        }

        //处理尾插
        if (index == len){
            addLast(elem);
            return;
        }
        //插入到中间位置
        //prev这个引用就对应index-1的位置
        LinkedNode prev=getIndexPos(index-1);
        //具体插入
        node.next=prev.next;
        prev.next=node;
    }

    private LinkedNode getIndexPos(int index){
        //是否要判断index是在有效范围呢？
        LinkedNode cur=this.head;
        for (int i = 0; i < index ; i++) {
            cur=cur.next;
        }
        return cur;
    }
    //获取链表的长度
    public int size(){
        int size=0;
        for (LinkedNode cur=this.head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }

    //查找是否包含关键字key是否在单链表当中---O(N)
    public boolean contains(int toFind){
        for (LinkedNode cur=this.head;cur!=null;cur=cur.next){
            if (cur.data==toFind){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点---O(N)
    public void remove(int toRemove){
        //核心是要找到要删除元素的前一个位置；特殊情况：
        //1.先单独处理空链表
        if (head==null){
            return;
        }
        //2.先考虑是否要删除的是头结点
        if (head.data == toRemove){
            this.head=this.head.next;      //
            return;
        }
        //3.删除中间节点：找到要删除节点的前一个节点
        LinkedNode prev = searchPrev(toRemove);
//        prev.next=prev.next.next;不好理解
        if (prev == null){
            return;
        }
        LinkedNode nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
    }

    //删除所有值为key的节点---O(N)
    public void removeAllKey(int toRemove){
        //判断是否为空
        if (head==null){
            return;
        }
        //先处理后续节点，最后处理头节点
        // 1    1     1     2     3
        LinkedNode prev = head;
        LinkedNode cur = head.next;
        while (cur != null){
            if (cur.data == toRemove){
            //cur对应的节点就应该删掉
                prev.next = cur.next;   //删除cur指向的节点
                cur=prev.next;          //让cur指向prev的下一个节点
            }else {
                //cur对应的节点不用删
                prev = cur;
                cur = cur.next;
            }
        }
        //处理头节点
        if (this.head.data == toRemove){
            this.head = this.head.next;
        }
        return;
    }

    private LinkedNode searchPrev(int toRemove){
        //判断是否为空
        if (this.head==null){
            return null;
        }
        //找到要删除元素的前一个位置
        LinkedNode prev=this.head;
        while (prev.next!=null){
            if (prev.next.data==toRemove){
                return prev;
            }
            prev=prev.next;
        }
        return null;//表示没找到
    }

    //打印链表中的所有元素
    public void display(){
        System.out.print("[");
        for (LinkedNode node = this.head;node != null;node = node.next) {
            System.out.print(node.data);
            if (node.next != null){
                //如果不是最后一个元素，就加上 ，
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public void clear(){
        //Java垃圾回收，后续的所以节点，只要这个节点没有引用指向他，就会被jvm判定为垃圾，会被自动回收
        this.head = null;
    }

}
