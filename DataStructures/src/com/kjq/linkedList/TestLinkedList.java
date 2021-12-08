package com.kjq.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 孔佳齐丶
 * @create 2021-12-08 下午6:34
 * @package com.kjq.linkedList
 */
public class TestLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        //测试
        int [] intArray = new int[]{5,4,9,1,7,8};

        MyLinkedList myLinkedList = new MyLinkedList();

        int j=1;
        for (int i : intArray) {
            myLinkedList.add(new MyNode(j++, i));
        }

        myLinkedList.list();
        int length = MyLinkedList.getLength(myLinkedList.getHead());
        System.out.println("该链表的有效长度是: " +length);
        MyNode lastIndexNode = MyLinkedList.findLastIndexNode(myLinkedList.getHead(), index);
        System.out.println("倒数第"+index+"个节点为 :" + lastIndexNode);

        //删除倒数节点
        assert lastIndexNode != null;
        myLinkedList.del(lastIndexNode.no);

        System.out.println(Arrays.toString(myLinkedList.returnArray()));
    }
}

class MyLinkedList{
    //先初始化一个头结点,头结点不要动
    private final MyNode head = new MyNode(0, 0);

    //返回头节点
    public MyNode getHead() {
        return head;
    }

    //返回该倒数节点
    public static MyNode findLastIndexNode(MyNode head, int index){
        // 判断如果链表为空,返回null
        if(head.next == null){
            return null; //没有找到,
        }
        //第一个遍历得到链表的长度(节点的个数)
        int size = getLength(head);
        //第二次遍历,size-index 位置,就是我们倒数的第k个节点
        //先做一个index校验
        if(index <= 0 || index > size){
            return null;
        }
        //定义一个辅助变量,temp,for循环定位到倒数的index
        MyNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //添加节点到单向链表
    public void add(MyNode node) {

        //因为head节点不能动,因此我们需要一个辅助遍历temp
        MyNode temp = head;
        //遍历链表,找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后,就将temp后移
            temp = temp.next;
        }
        //当退出while循环时,temp就指向了链表的最后
        //将最后这个节点的next 指向了新的节点
        temp.next = node;
    }

    //删除节点
    //思路
    //1. head节点不能动,因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时,是temp.next.no 和需要删除节点的no比较
    public void del(int no){
        MyNode temp = head;
        boolean flag = false;   //标志是否找到待删除节点的
        while (true){
            if(temp.next == null){  //已经到链表最后
                break;
            }
            if(temp.next.no==no){
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; // temp后移,遍历
        }
        //判断flag
        if(flag){   //找到
            //可以删除
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的%d节点不存在",no);
        }
    }

    public static int getLength(MyNode head){
        if(head.next==null){    //空链表
            return 0;
        }

        int length = 0;
        //定义一个辅助变量,
        MyNode cur = head.next;
        while(cur != null){
            length ++;
            cur = cur.next;
        }
        return length;
    }

    //显示链表[遍历]
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动,因此我们需要一个辅助变量来遍历
        MyNode temp = head.next;
        while (temp != null) {
            //判断是否到链表最后
            //输入节点的信息
            System.out.println(temp);
            //将next节点后移,一定小心,要不然会死循环
            temp = temp.next;
        }
    }

    //显示链表[遍历]
    public int [] returnArray() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        int [] intArray = new int[getLength(head)];
        int i = 0;
        //因为头结点不能动,因此我们需要一个辅助变量来遍历
        MyNode temp = head.next;
        while (temp != null) {
            //判断是否到链表最后
            int a = temp.getValue();
            intArray[i++] = a;
            //将next节点后移,一定小心,要不然会死循环
            temp = temp.next;
        }
        return intArray;
    }
}

class MyNode{
    public int no;
    public int value;
    public MyNode next; //指向下一个节点

    public MyNode(int no, int value){
        this.no = no;
        this.value = value;
    }

    @Override
    public String toString(){
        return "value = " +value +" no = " +no;
    }

    public int getValue(){
        return value;
    }
}
