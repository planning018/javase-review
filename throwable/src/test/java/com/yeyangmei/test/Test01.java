package com.yeyangmei.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: planning
 * @Date: 2019/5/26 11:38
 */
public class Test01 {

    // character replace
    @Test
    public void test1(){
        String str = "占_米";
        System.out.println(str.replace("_","1.9"));;
    }

}