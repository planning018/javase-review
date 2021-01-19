package com.planning.tools.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间处理工具类
 *
 * @author yxc
 * @date 2021/1/18 11:03
 */
public class LocalDateTools {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());

        System.out.println(System.currentTimeMillis());

        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        // 当天的 0点 - 24点
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8")));

        System.out.println(new Date(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        System.out.println(new Date(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8")) * 1000));


        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }


    public void todayMinMaxTime(){
        // 当天的 0点 - 24点()
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8")));
    }
}
