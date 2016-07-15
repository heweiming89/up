package cn.heweiming.up.test;

import org.springframework.transaction.annotation.Propagation;

import cn.heweiming.up.config.ShiroConfig;

/**
 * Created by heweiming on 2016/7/4.
 */
public class CodeTest {

    public static void main(String[] args) {
        System.out.println();
        String str = "中国";
        System.out.println("args = [" + args + "]");
        System.out.println("str = " + str);
        System.out.println("args = [" + args + "]");
        System.out.println("CodeTest.main");

    }
    
}
