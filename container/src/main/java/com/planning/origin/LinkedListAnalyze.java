package com.planning.origin;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 分析 LinkedList 源码
 * @Author: planning
 * @Date: 2019/7/15 10:52
 */
public class LinkedListAnalyze {

    @Test
    public void test(){
        List<String> strList = new LinkedList<>();
        strList.add("hello");
        strList.add("java");

        System.out.println(JSON.toJSONString(strList));

/*        Iterator<String> iterable = strList.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }*/

        for (String str: strList ) {
            System.out.println(str);
        }


    }


}