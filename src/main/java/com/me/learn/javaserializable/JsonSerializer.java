/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.javaserializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/9/12
 **/
public class JsonSerializer {

    public static void main(String[] aroutgs) throws IOException {
        User user = new User();
        user.setName("jed");
        user.setAge(12);
        byte[] data = serializeObject(user);
        deserializeObject(data);
    }
    public static byte[] serializeObject(User user) throws IOException {
        final String s = JSON.toJSONString(user);
        System.out.println("大小"+ s.getBytes().length);
        return s.getBytes();
    }

    public static void deserializeObject(byte[] data) {
        JSONObject user = JSON.parseObject(new String(data) );
        System.out.println(user);
    }
}
