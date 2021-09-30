/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.javaserializable;

import com.google.protobuf.InvalidProtocolBufferException;
import org.w3c.dom.CDATASection;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/9/12
 **/
public class ProtoBufSerializer {
    public static void main(String[] args) {
        final byte[] data = serializeObject();

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("序列化后的长度"+ data.length);
        deserializeObject(data);
    }

    public static byte[] serializeObject() {
//        8 12 18 3 74 101 100
        // 1<<<3|0 = 8
        //age 12
        //========name = jed
        //2<<<3|2 = 18
        //长度3
        //Jed J = 74, e=101, d=100

//        final UserProtos.User user = UserProtos.User.newBuilder().setAge(12).setName("Jed").build();


        final UserProtos.User user = UserProtos.User.newBuilder().setAge(300).setName("Jed").setStatus(-300).build();



        return user.toByteArray();
    }

    public static void deserializeObject(byte[] data) {
        try {
            final UserProtos.User user = UserProtos.User.parseFrom(data);
            System.out.println(user);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
