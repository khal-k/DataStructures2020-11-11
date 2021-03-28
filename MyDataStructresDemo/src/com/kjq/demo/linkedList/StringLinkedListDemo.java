package com.kjq.demo.linkedList;

/**
 * @author 孔佳齐丶
 * @create 2020-11-30 22:56
 * @package com.kjq.demo.linkedList
 */
public class StringLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        StringLinkedList singleLinkedList = new StringLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        //显示一把
        singleLinkedList.list();
    }
}

//定义一个singleLinedList,管理108位好汉
class StringLinkedList{
    //定义一个头结点,且头结点不能动
    private HeroNode head = new HeroNode(0, "", "");

    //添加英雄思路
    //遍历到最后一个节点,将要添加的节点放到最后一个节点的next即可
    public void add(HeroNode heroNode){
        //得有一个中间变量才能遍历,因为头结点不能动
        HeroNode temp = head;
        //使用while循环遍历,
        while (true){
            //遍历到最后一个节点,跳出循环,开始添加节点
            if(temp.next==null){
                break;
            }
            //如果没有找到最后,就指向下一个节点
           temp = temp.next;
        }
        //当退出while循环时,就指向了链表的最后
        temp.next = heroNode;
    }

    //遍历所有节点
    public void list(){
        //先判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,所以需要临时变量来遍历
        HeroNode temp = head.next;
        while(true){
            //如果下一个节点为空,则以遍历到最后一个节点
            if(temp == null){
                break;
            }
            //如果不为空
            System.out.println(temp);
            //指向下一个节点
            temp = temp.next;
        }
    }
}

//定义一个heroNode,每个HeroNode都是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;   //指向节点的下一个

    //提供一个构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //重写一个toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
