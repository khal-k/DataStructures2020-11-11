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
