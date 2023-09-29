package com.kcx.dao;

import com.kcx.extity.User;
import org.junit.Test;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 26/09/2023 5:44 pm
 */
public class TestUserDao {
    @Test
    public void testSave(){
        User user = new User("的萨芬","sdaf","sssss");
        new UserDao().save(user);
    }


    @Test
    public void testLogin(){
        System.out.println(new UserDao().login("jerry鼠", "shushu"));
        System.out.println(new UserDao().login("jerry鼠", "shushu1"));
    }
}
