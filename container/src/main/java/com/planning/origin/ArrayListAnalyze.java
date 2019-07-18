package com.planning.origin;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 分析 ArrayList 源码 --- JDK 1.8
 * @Author: planning
 * @Date: 2019/7/12 15:19
 */
public class ArrayListAnalyze {

    /**
     * 使用无参构造器，则使用数组 Object[] elementData 接收参数，默认大小是 10
     */
    @Test
    public void noParamConstructor(){
        List<String> strList = new ArrayList<>();
        strList.add("I");
        strList.add("want");
        strList.add("to");
        strList.add("know");
        strList.add("the");
        strList.add("truth");

        System.out.println(JSON.toJSONString(strList));
    }
}