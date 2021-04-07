package com.kjq.com.kjq.stack;

import java.util.Scanner;

/**
 * @author 孔佳齐丶
 * @create 2021-04-06 22:43
 * @package com.kjq.com.kjq.stack
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下,ArrayStack
        //先创建一个ArrayStack对象 -> 表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;    //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop){
            System.out.println("show: 表示显示栈...");
            System.out.println("exit: 退出程序...");
            System.out.println("push: 表示添加数据到栈(入栈)...");
            System.out.println("pop: 表示从栈取出数据(出栈)...");
            System.out.println("请输入你的选择...");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个整数");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("出栈元素为:"+res);
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
//创建一个类用来模拟栈
class ArrayStack{
    private int maxSize;    //栈的大小
    private int [] stack;   //数组, 数组模拟栈; 数据放在该数组中
    private int top = -1;   //top表示栈顶, 初始化值为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack =  new int [this.maxSize];
    }

    //栈满
    public boolean isFull(){
       return top == maxSize -1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈 push
    public void push(int value){
        if(isFull()){
            System.out.println("栈满...");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈pop
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空, 没有数据...");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况[遍历栈], 遍历时, 需要从栈顶开始显示元素
    public void list(){
        if(isEmpty()){
            System.out.println("栈空, 没有数据...");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
}
