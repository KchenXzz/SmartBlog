package com.kcx.extity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SplittableRandom;

/**
 * @author kcx
 * @version v1.0.0
 * @description 对应数据库中的article表的实体类
 * @createTime 25/09/2023 3:34 pm
 */

public class Article {


    //文章id
    private int oId;

    //文章标题
    private String title;

    //文章摘要
    private String abs;

    //评论数量
    private int commentCount;

    //浏览数
    private int viewCount;

    //正文
    private String content;

    //是否置顶
    private int putTop;

    //发布时间
    private long created;

    //图片名称
    private String imgName;

    //作者名
    private String username;

    //这篇文章关联的所有标签
    private List<Tag> tags;

    //年月日事件
    private String createStr;

    public Article() {
    }

    public Article(int oId, String title) {
        this.oId = oId;
        this.title = title;
    }

    public Article(int oId, String title, String abs, int commentCount, int viewCount, int putTop, long created, String imgName, String username) {
        this.oId = oId;
        this.title = title;
        this.abs = abs;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.putTop = putTop;
        this.created = created;
        this.imgName = imgName;
        this.username = username;
    }

    public Article(int oId, String title, String abs, int commentCount, int viewCount, String content, int putTop, long created, String imgName, String username) {
        this.oId = oId;
        this.title = title;
        this.abs = abs;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.content = content;
        this.putTop = putTop;
        this.created = created;
        this.imgName = imgName;
        this.username = username;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return abs
     */
    public String getAbs() {
        return abs;
    }

    /**
     * 设置
     * @param abs
     */
    public void setAbs(String abs) {
        this.abs = abs;
    }

    /**
     * 获取
     * @return commentCount
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * 设置
     * @param commentCount
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取
     * @return viewCount
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * 设置
     * @param viewCount
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return putTop
     */
    public int getPutTop() {
        return putTop;
    }

    /**
     * 设置
     * @param putTop
     */
    public void setPutTop(int putTop) {
        this.putTop = putTop;
    }

    /**
     * 获取
     * @return created
     */
    public long getCreated() {
        return created;
    }

    /**
     * 设置
     * @param created
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * 获取
     * @return imgName
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * 设置
     * @param imgName
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
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
     * @return tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 设置
     * @param tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * 获取
     * @return createStr
     */
    public String getCreateStr() {
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm");//2018-10-19 11:50
        //去数据库中查询这个文章的偏移量
        return format.format(new Date(this.created));
    }

    /**
     * 设置
     * @param createStr
     */
    public void setCreateStr(String createStr) {
        this.createStr = createStr;
    }

    public String toString() {
        return "Article{oId = " + oId + ", title = " + title + ", abs = " + abs + ", commentCount = " + commentCount + ", viewCount = " + viewCount + ", content = " + content + ", putTop = " + putTop + ", created = " + created + ", imgName = " + imgName + ", username = " + username + ", tags = " + tags + ", createStr = " + createStr + "}";
    }
}
