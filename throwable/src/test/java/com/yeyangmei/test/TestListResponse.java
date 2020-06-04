package com.yeyangmei.test;

import com.yeyangmei.bean.Person;
import lombok.Data;

import java.util.List;

/**
 * @author planning
 * @since 2020-04-28 10:34
 **/
@Data
public class TestListResponse {

    private List<Person> personList;
}