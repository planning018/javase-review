package com.planning.container.test;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yxc
 * @date 2021/4/14 14:21
 */
public class StreamFunctionTest {

    private void filterValue(List<Integer> numList){
        numList = numList.stream().filter(num -> num < 5).collect(Collectors.toList());
    }

    @Test
    public void testFilter(){
        List<Integer> numList = Lists.newArrayList(1,2,3,4,5,6);
        filterValue(numList);
        System.out.println(JSON.toJSONString(numList));
    }
}
