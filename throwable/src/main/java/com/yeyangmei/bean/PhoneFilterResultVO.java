package com.yeyangmei.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author yxc
 * @since 2020-06-03 16:28
 **/
@Data
public class PhoneFilterResultVO {

    private String reason;

    private Long taskId;

    private Long taskTypeId;

    private Boolean testValue;

    private List<Map<String,Object>> extData;

}

