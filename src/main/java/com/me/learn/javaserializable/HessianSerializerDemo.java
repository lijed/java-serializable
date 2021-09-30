/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.javaserializable;

import com.caucho.hessian.io.Hessian2Constants;
import com.caucho.hessian.io.HessianOutput;

import java.io.*;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/9/12
 **/
public class HessianSerializerDemo {
    public static void main(String[] aroutgs) throws IOException {
        User user = new User();
        user.setName("jed");
        user.setAge(12);
        serializeObject(user);
    }

    public static byte[] serializeObject(User user) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(baos);
        ho.writeObject(user);
        return baos.toByteArray();
    }
}
