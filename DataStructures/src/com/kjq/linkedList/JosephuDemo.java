package com.kjq.linkedList;

/**
 * @author 孔佳齐丶
 * @create 2021-04-06 08:10
 * @package com.kjq.linkedList
 */
public class JosephuDemo {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试小孩出圈,
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

//创建一个环形单向链表
class CircleSingleLinkedList{
    //创建一个first节点, 当前没有编号
    private Boy first = new Boy(-1);
    //添加小孩节点,构建成一个环形链表
    public void addBoy(int nums){
        //nums 做一个数组校验
        if(nums < 1){
            System.out.println("nums 的值不正确");
            return;
        }
        Boy curBoy = null;  //辅助指针, 帮助构建环形链表
        //使用一个for循环, 来创建我们的环形链表
        for (int i =1; i <= nums; i++){
            //根据编号,创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i == 1){
                first = boy;
                first.setNext(first);   //构成环
                curBoy = first; //让curBoy指向第一个小孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        //先判断链表是否为空
        if(first == null){
            System.out.println("链表为空...");
            return;
        }
        //因为first不能动, 因此我们使用一个辅助指针完成遍历
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号 %d\n" ,curBoy.getNo());
            if(curBoy.getNext() == first){  //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入, 计算出小孩出圈的顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始
     * @param countNum 表示数几下
     * @param nums 表示最初由多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum , int nums){
        //先对数据进行校验
        if(first == null || startNo <1 || startNo > nums){
            System.out.println("参数输入有问题...请重新输入");
            return;
        }
        //创建要给辅助指针, 帮助小孩出圈
        Boy helper = first;
        //需要创建一个辅助指针(变量) helper, 事先应该指向环形链表的最后这个节点
        while(true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前, 先让first 和 helper 移动k - 1次
        for(int j = 0; j < startNo -1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时,让first和helper 指针同时移动 m - 1 次
        //这里是一个循环的操作, 直到圈中只有一个节点
        //说明圈中只有一个节点
        while (helper != first) {
            //让first和helper 指针同时移动 countNum -1 次,
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点,就是要出圈的小孩节点
            System.out.printf("小孩 %d 出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号 %d \n" ,first.getNo());
    }
}

//创建一个boy类, 表示一个节点
class Boy{
    private int no;     //编号
    private Boy next;   //指向下一个节点, 默认null
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
