package com.kjq.com.kjq.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 孔佳齐丶
 * @create 2021-04-15 23:07
 * @package com.kjq.com.kjq.stack
 */
public class PolandNotion {
    public static void main(String[] args) {
        //先定义给逆波兰表达式
        //(3+4)*5-6  =>  3 4 + 5 * 6 -
        //说明为了方便, 逆波兰表达式的数字和字符使用空格展开
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1. 先将"3 4 + 5 * 6 -" => 放到ArrayList中
        System.out.println(getListString(suffixExpression));
        //2. 将ArrayList 传递给一个方法, 遍历ArrayList 配合栈, 完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList = "+list);
        int res = calculate(list);
        System.out.println("计算的结果是:"+res);
    }

    //方法:将 中缀表达式转成对应的List
    // s = "1+((2+3)*4)-5"
    public static List<String> toInFixExpressionList(String expression){
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0;  //这是一个指针, 用于遍历中缀表达式字符串f
        String str; //对多为数凭借
        char c; //每遍历一个字符, 就放到c
        do{
            //如果c是一个非数字, 需要加入到lsƒ
            if((c=expression.charAt(i)) < 48 || (c=expression.charAt(i)) > 57){
                ls.add("" + c);
                i++;    //指针后移R
            }else{  //如果是一个数, 需要考虑多位数
                str=""; //先将str 置成""
                while(i < expression.length() && (c=expression.charAt(i))>=48 &&
                        (c=expression.charAt(i))<=57){

                }
            }
        }while (i< expression.length());
        return null;
    }

    //将一个逆波兰表达式, 依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将字符串通过空格分割
        String [] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, split);
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> list){
        //创建给栈,只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String s : list) {
            //这里使用正则表达式来取数
            if(s.matches("\\d+")){
                //入栈
                stack.push(s);
            }else {
                //pop出两个数,并运算,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(s.equals("+")) {
                    res = num1 + num2;
                }else if(s.equals("-")){
                    res = num1 - num2;
                }else if(s.equals("/")){
                    res = num1/num2;
                }else if(s.equals("*")) {
                    res = num1 * num2;
                }else {
                    throw new RuntimeException("运算符有问题");
                }
                //把res入栈
                stack.push(res+"");
            }
        }
        //最后留在stack中的数据, 就是运算结果
        return Integer.parseInt(stack.pop());
    }

}
