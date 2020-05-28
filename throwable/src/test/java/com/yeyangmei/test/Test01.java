package com.yeyangmei.test;

import com.google.common.collect.Lists;
import com.yeyangmei.bean.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: planning
 * @Date: 2019/5/26 11:38
 */
public class Test01 {

    private static Logger logger = LoggerFactory.getLogger(Test01.class);

    // character replace
    private String replace(String truckLength, String occupyTruckLength) {
        // 场景1： 3.4,4.7,8 ---> 3.4/4.7/8米
        //String str1 = "3.4,4.7,8";

        String truckLengthResult = dealTruckLength(truckLength);

        String occupyTruckLengthResult = "";
        if (!StringUtils.isBlank(occupyTruckLength)) {
            occupyTruckLengthResult = "/占_米".replace("_", occupyTruckLength);
        }

        if (StringUtils.isBlank(truckLengthResult)) {
            occupyTruckLengthResult = occupyTruckLengthResult.replace("/", "");
        }

        return truckLengthResult + occupyTruckLengthResult;
    }

    private String dealTruckLength(String truckLength) {
        if (StringUtils.isBlank(truckLength)) {
            logger.info("字符串不合法");
            return "";
        }

        if ("-1".equals(truckLength)) {
            return "不限车长";
        }

        return truckLength.replace(",", "/") + "米";

/*        List<String> str1List = Arrays.asList(truckLength.split(","));
        if(str1List.contains("-1")){
            return "不限车长";
        }
        StringBuilder sbf = new StringBuilder();
        for(String str : str1List){
            sbf.append(str);
            if((str1List.indexOf(str) + 1) != str1List.size()){
                sbf.append("/");
            }
        }
        sbf.append("米");
        return sbf.toString();*/
    }

    private String finalTruckLengthNew(String truckLength, String occupyTruckLength) {
        List<String> lengthList = Lists.newArrayList();
        if (StringUtils.isNotBlank(truckLength)) {
            List<String> realLengthList = Arrays.asList(truckLength.split(","));
            if (realLengthList.contains("-1")) {
                lengthList.add("不限车长");
            } else {
                lengthList.addAll(realLengthList);
                int index = lengthList.size() - 1;
                lengthList.set(index, lengthList.get(index) + "米");
            }
        }

        if (StringUtils.isNotBlank(occupyTruckLength)) {
            lengthList.add("占_米".replace("_", occupyTruckLength));
        }

        return StringUtils.join(lengthList.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList()), "/");
    }

    @Test
    public void testSubstring() {
        String str = "hello";
        System.out.println(str.substring(0, 3));

        System.out.println("result is :" + 12432311 % 100);
        System.out.println("result is :" + 12432312 / 100);

    }

    @Test
    public void testListCompare() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 3);

        System.out.println(list1.containsAll(list2));
    }

    @Test
    public void test() {
        String truckLength = "1.2,2.3,4";
        String truckLength1 = "-1";
        String truckLength2 = "";
        String truckLength3 = "1.2";

        String occupyTruckLength = "1.7";
        String occupyTruckLength1 = " ";
        String occupyTruckLength2 = null;
        //System.out.println("result is " + replace(truckLength, occupyTruckLength));
        //logger.info("result is {}", replace(truckLength2,occupyTruckLength));
        System.out.println(dealTruckLength(truckLength3));

        //logger.info(finalTruckLengthNew(truckLength,occupyTruckLength2));
    }

    @Test
    public void testObject() {
        Person p1 = new Person("zhangsan", "123");
        p1 = changePerson(p1, true);
        System.out.println(p1.toString());
    }

    private Person changePerson(Person p1, boolean judge) {
        if (judge) {
            Person p2 = new Person("lisi", "234");
            return p2;
        }
        return p1;
    }

    @Test
    public void test11() {
//        Map map = new HashMap();
//        System.out.println(map.values());

        System.out.println(hailstone(27));
        System.out.println(hailstone(42));
    }

    private int hailstone(int n) {
        int length = 1;
        while (n > 1) {
            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
            System.out.print(n+ " ");
            length++;
        }
        return length;
    }

}