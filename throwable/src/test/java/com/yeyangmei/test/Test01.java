package com.yeyangmei.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: planning
 * @Date: 2019/5/26 11:38
 */
public class Test01 {

    private static Logger logger = LoggerFactory.getLogger(Test01.class);

    // character replace
    private String replace(String truckLength, String occupyTruckLength){
        // 场景1： 3.4,4.7,8 ---> 3.4/4.7/8米
        //String str1 = "3.4,4.7,8";

        String truckLengthResult = dealTruckLength(truckLength);

        String occupyTruckLengthResult = "";
        if(!StringUtils.isBlank(occupyTruckLength)){
            occupyTruckLengthResult = "/占_米".replace("_", occupyTruckLength);
        }

        return truckLengthResult + occupyTruckLengthResult;
    }

    private String dealTruckLength(String truckLength){
        if(StringUtils.isBlank(truckLength)){
            // TODO: 2019/9/19 稍后配置一下 log4j 的配置文件
            logger.info("字符串不合法");
            return "";
        }
        List<String> str1List = Arrays.asList(truckLength.split(","));
        StringBuilder sbf = new StringBuilder();
        for(String str : str1List){
            if("-1".equals(str)){
                return "不限车长";
            }
            sbf.append(str);
            if((str1List.indexOf(str) + 1) != str1List.size()){
                sbf.append("/");
            }
        }
        sbf.append("米");
        return sbf.toString();
    }

    @Test
    public void test(){
        String truckLength = "1.2,2.3,4";
        String truckLength1 = "-1";
        String truckLength2 = "";

        String occupyTruckLength = "1.7";
        String occupyTruckLength1 = " ";
        String occupyTruckLength2 = null;
        System.out.println("result is " + replace(truckLength, occupyTruckLength));
        logger.info("result is {}", replace(truckLength,occupyTruckLength));
    }

}