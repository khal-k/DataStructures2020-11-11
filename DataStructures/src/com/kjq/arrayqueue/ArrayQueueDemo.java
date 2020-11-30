package com.kjq.arrayqueue;

import java.util.Scanner;

/**
 * @author 孔佳齐丶
 * @create 2020-11-30 21:41
 * @package com.kjq.arrayqueue
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 测试
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; // 接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头数据");

            key = sc.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;

                case 'a':
                    System.out.println("输入一个数");
                    int value = sc.nextInt();
                    arrayQueue.addQueue(value);
                    break;

                case 'g': // 取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的头数据%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出...");
    }
}

//使用数字模拟列-编写一个arrayQueue类
class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 对列尾
    private int[] arr; // 该数据用于存放数据,模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部,分析front是指向队列头的第一个位置
        rear = -1; // 指向队列为,指向队列的数据(就是队列的最后一个数据)
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpyt() {
        return rear == front;
    }

    // 添加数据队列
    public void addQueue(int n) {
        // 判断队列是否满了
        if (isFull()) {
            System.out.println("队列满,不能加入数据...");
            return;
        }
        rear++; // 让rear后移
        arr[rear] = n;
    }

    // 获取队列的数据,出队列
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpyt()) {
            // 通过抛出异常处理;
            throw new RuntimeException("队列空,不能取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列所有数据
    public void showQueue() {
        // 遍历
        if (isEmpyt()) {
            System.out.println("队列为空,没有数据...");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据,注意不是取数据
    public int headQueue() {
        // 判断
        if (isEmpyt()) {
            throw new RuntimeException("队列空的,没有数据....");
        }
        return arr[front + 1];
    }
}
