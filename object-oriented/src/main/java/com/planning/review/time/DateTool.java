package com.planning.review.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * 时间处理
 * @author planning
 * @since 2019-12-24 15:46
 **/
public class DateTool {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());

        System.out.println(System.currentTimeMillis());
    }
}