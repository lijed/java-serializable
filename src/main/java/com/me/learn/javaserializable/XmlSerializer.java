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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.IOException;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/9/12
 **/
public class XmlSerializer {
    private static XStream xStream = new XStream(new DomDriver());

    static {
        xStream.allowTypes(new Class[]{User.class});
//        xStream.addPermission(AnyTypePermission.ANY);
    }

    public static void main(String[] aroutgs) throws IOException {
        User user = new User();
        user.setName("jed");
        user.setAge(12);
        byte[] data = serializeObject(user);
        System.out.println("序列化后的字节数" + data.length);
        deserializeObject(data);
    }
    public static byte[] serializeObject(User user) throws IOException {
        final String xml = xStream.toXML(user);
        System.out.println("data: " + xml);
        return xml.getBytes();
    }

    public static void deserializeObject(byte[] data) {

        final Object user= xStream.fromXML(new String(data));
        System.out.println(user);
    }
}
