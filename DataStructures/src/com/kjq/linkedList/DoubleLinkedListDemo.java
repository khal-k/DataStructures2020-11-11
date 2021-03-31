package com.kjq.linkedList;

/**
 * @author 孔佳齐丶
 * @create 2021-03-31 22:36
 * @package com.kjq.linkedList
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

//创建一个双向链表的列
class DoubleLinedList{
    //先初始化一个头结点,头结点不要动
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //修改单向链表

    //增加节点
    public void add(HeroNode2 heroNode2){
        //因为头节点不能动, 所以需要一个辅助节点
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //形成一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    //遍历链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空...");
        }
        //定义一个遍历...
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义一个HeroNode2, 每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;  //链表的下一个节点 , 默认为null
    public HeroNode2 pre;   //链表的上一个节点 , 默认为null

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
