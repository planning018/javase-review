package com.planning.algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 删除排序数组中的重复项
 *
 * @author yxc
 * @since 2020-10-10 14:19
 **/
public class Demo01 {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    @Test
    public void test(){
        int[] intArray = {1,1,2};
        System.out.println(removeDuplicates(intArray));
        System.out.println(JSON.toJSONString(intArray));
    }
}