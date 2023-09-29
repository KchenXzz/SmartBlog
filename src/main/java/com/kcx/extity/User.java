package com.kcx.extity;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 26/09/2023 5:36 pm
 */
public class User {
    private int oId;
    private String username;
    private String password;
    private String email;


    public User() {
    }

    public User(int oId, String username, String password, String email) {
        this.oId = oId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * 获取
     * @return oId
     */
    public int getOId() {
        return oId;
    }

    /**
     * 设置
     * @param oId
     */
    public void setOId(int oId) {
        this.oId = oId;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "User{oId = " + oId + ", username = " + username + ", password = " + password + ", email = " + email + "}";
    }
}
