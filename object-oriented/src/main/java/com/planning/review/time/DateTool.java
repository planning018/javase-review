package com.planning.review.time;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 时间处理
 * @author planning
 * @since 2019-12-24 15:46
 **/
public class DateTool {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());

        System.out.println(System.currentTimeMillis());

        // 当天的 0点 - 24点
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8")));

        System.out.println(new Date(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        System.out.println(new Date(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8")) * 1000));


        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }

    @Test
    public void testBigDecimal(){
        Double right = 8.2;
        // 存在精度问题
        System.out.println((int)(right.doubleValue() * 100));

        // 解决精度问题
        System.out.println(BigDecimal.valueOf(right).multiply(new BigDecimal(100)).intValue());
        System.out.println(new BigDecimal(String.valueOf(right)).multiply(new BigDecimal(100)).intValue());
    }
}