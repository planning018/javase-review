package com.planning.review.basic;

import com.planning.review.classloader.PathClassLoader;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

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
        System.out.println(499 / 20);
    }

    @Test
    public void testClassLoader(){
        PathClassLoader pathClassLoader = new PathClassLoader("com.planning.review.array.ArraySort");

    }

    @Test
    public void testCal(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        System.out.println(hours);
        System.out.println(hours/6 + 1);
    }
}
