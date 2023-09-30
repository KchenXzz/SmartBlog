package com.kcx.extity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文章评论实体类
 */
public class Comment {

    private String content;//评论内容
    private long created;//评论时间
    private  String name;//评论人名

    private int onId;//文章id
    private int userId;//评论者id
    private int originalCommentId;//父评论id
    private int originalCommentName;//父评论用户名

    private String createdStr;

    public Comment() {
    }

    public Comment( String content, long created, String name, int onId, int userId) {
        this.content = content;
        this.created = created;
        this.name = name;
        this.onId = onId;
        this.userId = userId;
    }

    public Comment(int onId, String content, long created, String name) {
        this.onId=onId;
        this.content = content;
        this.created = created;
        this.name = name;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedStr() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=new Date(created);
        return sdf.format(date);
    }
    public void setCreatedStr(String createdStr) {
        this.createdStr = createdStr;
    }


    /**
     * 获取
     * @return onId
     */
    public int getOnId() {
        return onId;
    }

    /**
     * 设置
     * @param onId
     */
    public void setOnId(int onId) {
        this.onId = onId;
    }

    /**
     * 获取
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return originalCommentId
     */
    public int getOriginalCommentId() {
        return originalCommentId;
    }

    /**
     * 设置
     * @param originalCommentId
     */
    public void setOriginalCommentId(int originalCommentId) {
        this.originalCommentId = originalCommentId;
    }

    /**
     * 获取
     * @return originalCommentName
     */
    public int getOriginalCommentName() {
        return originalCommentName;
    }

    /**
     * 设置
     * @param originalCommentName
     */
    public void setOriginalCommentName(int originalCommentName) {
        this.originalCommentName = originalCommentName;
    }

    public String toString() {
        return "Comment{content = " + content + ", created = " + created + ", name = " + name + ", onId = " + onId + ", userId = " + userId + ", originalCommentId = " + originalCommentId + ", originalCommentName = " + originalCommentName + ", createdStr = " + createdStr + "}";
    }
}
