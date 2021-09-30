/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.javaserializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/9/12
 **/
public class SerialiableDemo {
    public static void main(String[] aroutgs) throws IOException {
        User user = new User();
        user.setName("jed");
        user.setAge(12);
        serializeObject(user);
    }

    public static void serializeObject(User user) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(new File("user")));
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
