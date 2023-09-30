package com.kcx.extity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��������ʵ����
 */
public class Comment {

    private String content;//��������
    private long created;//����ʱ��
    private  String name;//��������

    private int onId;//����id
    private int userId;//������id
    private int originalCommentId;//������id
    private int originalCommentName;//�������û���

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
     * ��ȡ
     * @return onId
     */
    public int getOnId() {
        return onId;
    }

    /**
     * ����
     * @param onId
     */
    public void setOnId(int onId) {
        this.onId = onId;
    }

    /**
     * ��ȡ
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ����
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * ��ȡ
     * @return originalCommentId
     */
    public int getOriginalCommentId() {
        return originalCommentId;
    }

    /**
     * ����
     * @param originalCommentId
     */
    public void setOriginalCommentId(int originalCommentId) {
        this.originalCommentId = originalCommentId;
    }

    /**
     * ��ȡ
     * @return originalCommentName
     */
    public int getOriginalCommentName() {
        return originalCommentName;
    }

    /**
     * ����
     * @param originalCommentName
     */
    public void setOriginalCommentName(int originalCommentName) {
        this.originalCommentName = originalCommentName;
    }

    public String toString() {
        return "Comment{content = " + content + ", created = " + created + ", name = " + name + ", onId = " + onId + ", userId = " + userId + ", originalCommentId = " + originalCommentId + ", originalCommentName = " + originalCommentName + ", createdStr = " + createdStr + "}";
    }
}
