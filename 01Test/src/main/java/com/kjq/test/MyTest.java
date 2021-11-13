package com.kjq.test;

/**
 * @author 孔佳齐丶
 * @create 2021-08-04 23:09
 * @package com.kjq.test
 */
public class MyTest {
    public static void main(String[] args) {
        String str1 = "abbcdefghabbcdefgabbc";
        StringBuilder sb = new StringBuilder();
        char ch1;
        int index = 0;
        for (int i = 0; i < str1.length(); i++) {
        if(str1.charAt(0) == str1.charAt(i) && 0!= i){
            System.out.println(str1.charAt(i) +"=="+i);
            }
        }
    }
}
