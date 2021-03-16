package com.planning.review.basic;

import com.planning.review.classloader.PathClassLoader;
import org.junit.Test;

/**
 * @author yxc
 * @date 2021/2/2 9:39
 */
public class DemoTest {

    @Test
    public void testMath(){
        Double num1 = 3.9;
        System.out.println(num1 / 100);
        System.out.println( 60/100.0);
    }

    @Test
    public void testClassLoader(){
        PathClassLoader pathClassLoader = new PathClassLoader("com.planning.review.array.ArraySort");

    }
}
