package com.planning.review;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author yxc
 * @since 2020-09-10 16:01
 **/
public class BasicTest {

    @Test
    public void testFormatDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean dateChoose = dateFormat.parse("2020-09-01 11:39:04").getTime() > dateFormat.parse("2020-09-09 02:41:47").getTime();
        System.out.println(dateChoose);
    }
}