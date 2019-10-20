package cn.LinekList;

public class SeqList {
    //最大容量为10，初始情况下，这10个元素并不一定都是有效元素；执行插入操作，插入的元素才是有效元素
    private int[] data = new int[10];
    //size表示当前数组中有多少个有效元素
    private int size = 0;
    // 打印顺序表
    public void display(){
        //System.out.println(Arrays.toString(data));
        //打印有效元素
        System.out.print("[");
        for (int i = 0; i < size ; i++) {
            System.out.print(data[i]);
            if (i != size-1){      //是不是最后一个元素
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    // 在pos(下标)位置新增元素;elem表示插入的元素
    //插入的时间复杂度是O(N)
        public void add(int pos, int elem) {
            //pos==size也允许插入，此时相当于尾插
            if (pos < 0 || pos > size){
                //pos位置无效
                return;
            }
            if (this.size >= this.data.length){
                //当前容量不够，需要扩容
                //申请空间，把原有数据拷贝过去
                realloc();
            }
        if (pos == size){
            //尾插，直接把新元素放到size下标的位置
            this.data[pos]= elem;
            this.size++;
            return;
        }
        //处理插入在中间位置的情况，进行搬运，把后面的元素依次往后挪
        for (int i = this.size ; i > pos;i--) {
            this.data[i]=this.data[i - 1];
        }
        this.data[pos] = elem;
        this.size++;
    }
    //扩容方法
    private void realloc(){
        //扩容策略根据实际问题场景的特点来决定具体是线性增长还是指数增长；让扩容的次数尽量少
<<<<<<< HEAD
        int[] newData = new int[this.data.length * 2];
=======
        int[] newData=new int[this.data.length * 2];
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
        for (int i = 0; i <this.data.length ; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
//        for (int i=0;i < this.size;i++){
//            if (this.data[i] == toFind){
//                return true;
//            }
//        }
//        return false;
        return this.search(toFind) != -1;  //!= -1表示找到
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
<<<<<<< HEAD
        for (int i = 0;i < this.size;i++){
=======
        for (int i=0;i < this.size;i++){
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
            if (this.data[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        return this.data[pos];
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int elem) {
        this.data[pos] = elem;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //删除可以按位置删除，也可以按值删除(下面实现)
        //删除第一次出现的值
        int pos = search(toRemove);
        if (pos == -1){
            //值不存在，不必删除
            return;
        }
        if (pos == this.size-1){
            //如果size是最后一个元素，则size--
            this.size--;
            return;
        }
        //删除普通位置，需要搬运
        for (int i = pos; i < size - 1 ; i++) {
<<<<<<< HEAD
            this.data[i] = this.data[i+1];
=======
            this.data[i]=this.data[i+1];
>>>>>>> c7a46d79baca0b7e2ab1778f9734db5fd59379a3
        }
        this.size--;
    }

    // 获取顺序表长度
    public int size() {
        return this.size;
    }

    // 清空顺序表
    public void clear() {
        this.size = 0;
        this.data = new int[10];
    }

}
