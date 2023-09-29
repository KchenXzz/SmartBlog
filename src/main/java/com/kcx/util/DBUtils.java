package com.kcx.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtils {

    private static BasicDataSource ds;

    static {

        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties p = new Properties();

        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver = p.getProperty("driver");
        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String pwd = p.getProperty("password");


        ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(pwd);

        ds.setInitialSize(3);
        ds.setMaxActive(5);
        ds.setMaxIdle(3);


        System.out.println(ds);
    }

    public static Connection getConn()  {
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
