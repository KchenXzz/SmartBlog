package com.kcx.dao;

import com.kcx.extity.Tag;
import com.kcx.extity.User;
import com.kcx.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description 用户相关的数据操作
 * @createTime 26/09/2023 5:37 pm
 */
public class UserDao {


    /**
     * 用户注册
     */
    public void save(User user) {
        try (Connection conn = DBUtils.getConn()) {
            String sql = "INSERT INTO user(userName,email,password) VALUES (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 用户登录 通过判断用户名密码是否匹配
     * @param username 用户名
     * @param password 密码
     * @return 是否匹配
     */
    public boolean login(String username, String password) {//改成返回user对象 null登录失败
        try (Connection conn = DBUtils.getConn()) {
            String sql = "SELECT COUNT(*) FROM user WHERE userName=? AND password=?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet set = pst.executeQuery();
            if (set.next() && set.getInt(1) > 0) {
                return true;
            } else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
