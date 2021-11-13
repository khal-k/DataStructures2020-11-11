package com.kjq.test;

import java.util.Optional;

/**
 * @author jy
 * @date 2021/8/4 22:55
 */
public class StringDemo {
    public static void main(String[] args) {
        String str0 = "声明式事务的配置：1、配置增强细节：读方法的增强和写方法的增强2、配置要进行事务控制的方法（切点）3、将增强用到切点上1234567890声明式事务的配置：1、配置增强细节：读方法的增强和写方法的增强2、配置要进行事务控制的方法（切点）3、将增强用到切点上";
        String str1 = "";
        String str2 = null;
        String str = Optional.ofNullable(str0).orElse("");
        function1(str);
        //function2(str);
    }

    /**
     * 垃圾代码
     * @param str
     */
    private static void function2(String str) {
        if(str.length()>10){
            String tag = str.substring(0, 10);
            if(str.contains(tag)){
                System.out.println(str.substring(str.lastIndexOf(tag)));
            }
        }
    }

    /**
     * 蠢代码
     * @param str
     */
    private static void function1(String str) {
        int end = str.length() / 2;
        System.out.println(str.length());
        for (int i = 10; i <= end; i++) {
            if(str.substring(0,i).equals(str.substring(i,i+i))){
                System.out.println(str.substring(i));
            }
        }
    }
}
