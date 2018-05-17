package com.hzg.springmvc.test;

import com.hzg.ssm.util.CharUtil;
import org.junit.Test;

public class TestZH {

    /**
     * 打印所有汉字
     */
    @Test
    public void test1(){
        int nums = 0;
        for (int i = 0x4e00; i <= 0x9fa5; i++){
            char c = (char)i;
            System.out.print(c);
            nums++;
            if (nums > 51){
                System.out.println();
                nums = 0;
            }
        }
    }

    /**
     * 判断字符串是否包含汉字
     */
    @Test
    public void test2(){
        String str = "a在dbn中!!！";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int code = (int)c;
            if (code >= 0x4e00 && code <= 0x9fa5){
                System.out.println("str[" + i + "]是汉字");

            }
        }
    }

    /**
     * 得到十个名字
     */
    @Test
    public void test3(){
        for (int i = 0; i < 10; i++) {
            System.out.println(CharUtil.getName3ZH());
        }
    }

}
