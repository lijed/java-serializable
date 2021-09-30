/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.javaserializable;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/9/12
 **/

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 7461854122411858185L;

    //验证对象是否发生了变更
//    private static final long serialVersionUID = -4358526800147598852L;

    private String name;
    private transient int age;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(name);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.name=(String)in.readObject();
    }
}
