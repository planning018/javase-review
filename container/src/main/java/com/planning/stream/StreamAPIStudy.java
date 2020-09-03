package com.planning.stream;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * learn Streams API
 */
public class StreamAPIStudy {

    /**
     * 构造流的几种常用方法
     */
    private void constructStream(){
        // 1. Individual values
        Stream<String> stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray =  new String[]{"a","b","c"};
        stream = Stream.of(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }

    /**
     * 数值流的构造
     */
    private static void constructIntStream(){
        IntStream.of(new int[]{1,2,3}).forEach(System.out :: print);
        System.out.println();
        IntStream.range(1,3).forEach(System.out :: print);
        System.out.println();
        IntStream.rangeClosed(1,3).forEach(System.out :: print);
    }

    /**
     * 流转换为其他数据结构
     */
    private static void streamToOther(){
        Stream<String> stream = Stream.of("a", "b", "c");

        // 1. Array
        String[] strArray1 = stream.toArray(String[]::new);
        // 2. Collections
        List<String> list1 = stream.collect(Collectors.toList());
        ArrayList<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set<String> set1 = stream.collect(Collectors.toSet());
        Stack<String> stack = stream.collect(Collectors.toCollection(Stack::new));
        // 3. String
        String str = stream.collect(Collectors.joining()).toString();
    }

    /**
     * 把所有单词转为大写
     */
    private static void streamToUppercase(){
        List<String> wordList = Arrays.asList("hello", "world");
        List<String> output = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(output));
    }

    private static void streamSquare(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(squareNums));
    }

    private static void streamFlatMap(){
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(0, 1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream()); // can be replace by : Collection :: stream
        System.out.println(JSON.toJSONString(outputStream.collect(Collectors.toList())));
    }

    private static void streamFilterNum(){
        Integer[] sixNums = {1,2,3,4,5,6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println(JSON.toJSONString(evens));
    }

    /**
     * reduce 的用例
     */
    private static void streamReduce(){
        // 字符串拼接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("concat result is " + concat);

        // 求最小值
        Double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("minValue result is " + minValue);

        // 求和
        Integer sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum); // 有起始值
        sumValue = Stream.of(1,2,3,4).reduce(Integer::sum).get(); // 无起始值
        System.out.println("sumValue result is " + sumValue);

        // 过滤 + 字符串拼接
        String concatResult = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
        System.out.println("concatResult result is " + concatResult);
    }

    public void testFindMin(){
        List<Integer> data = Arrays.asList(1,2,3,4,5);
        // data.stream().collect()
    }










    public static void main(String[] args) {
        //constructIntStream();
        //streamToOther();
        //streamToUppercase();
        //streamSquare();
        //streamFlatMap();

        //streamFilterNum();
        streamReduce();

        // TODO: 2019/9/26 后续在补充 limit/skip,  sorted, min/max/distinct, Match 等 API
    }



}
