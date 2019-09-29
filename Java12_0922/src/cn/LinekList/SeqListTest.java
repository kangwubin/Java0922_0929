package cn.LinekList;

public class SeqListTest {
    public static void main(String[] args) {
        TestAdd();
        TestContains();
        TestSearch();
        TestRemove();
    }

    public static void TestAdd(){
        System.out.println("测试Add方法！");
        SeqList seqList = new SeqList();
//        seqList.display();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(2,5);
        seqList.display();
    }

    public static void TestContains(){
        System.out.println("测试Contains方法！");
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(2,5);
        boolean result=seqList.contains(5);
        System.out.println(result);
    }

    public static void TestSearch(){
        System.out.println("测试Search方法！");
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(2,5);
        int result=seqList.search(5);
        System.out.println("result预期是2，实际是："+result);
    }

    public static void TestRemove(){
        System.out.println("测试Remove方法！");
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(2,5);
        seqList.remove(3);
        System.out.println("预期值是：[1,2,5,4]");
        System.out.println("实际值是：");
        seqList.display();
    }

}
