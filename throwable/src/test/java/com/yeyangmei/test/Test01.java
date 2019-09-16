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

    @Test
    public void test() throws IOException {
        String params = "127.0.0.1";
        Runtime rt = Runtime.getRuntime();
        String[] cmd = new String[3];
        cmd[0] = "cmd.exe" ;
        cmd[1] = "/C";
        cmd[2] = "ping " + params;
        Process p = rt.exec(cmd);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }
        br.close();
        System.out.println(sb.toString().replaceAll("&nbsp",""));
    }

}