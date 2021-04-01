package com.kjq.linkedList;

/**
 * @author 孔佳齐丶
 * @create 2021-03-31 22:36
 * @package com.kjq.linkedList
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个链表
        DoubleLinedList doubleLinedList = new DoubleLinedList();
        //加入
        doubleLinedList.add(hero1);
        doubleLinedList.add(hero2);
        doubleLinedList.add(hero3);
        doubleLinedList.add(hero4);

        doubleLinedList.list();

        //修改节点
        System.out.println("修改节点");
        HeroNode2 newHeroNode2 = new HeroNode2(2, "小卢", "小麒麟~~~");
        doubleLinedList.update(newHeroNode2);
        doubleLinedList.list();

        //删除节点
        System.out.println("删除节点");
        doubleLinedList.delete(4);
        doubleLinedList.list();
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

    //删除双向链表的节点
    public void delete (int no){
        if(head.next ==null){
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            //如果是最后一个节点, 就不需要执行下面这句话,
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }
    }

    //修改双向链表
    public void update(HeroNode2 heroNode2){
        if(head.next == null){
            System.out.println("链表为空");
        }
        // 找到需要修改的节点, temp为修改的节点9
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(heroNode2.no == temp.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = heroNode2.name;
            temp.nickName = heroNode2.nickName;
        }else {
            System.out.printf("该节点的编号不存在 %d",heroNode2.no);
        }
    }

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
