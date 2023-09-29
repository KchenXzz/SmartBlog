package com.kcx.extity;

/**
 * @author kcx
 * @version v1.0.0
 * @description 对应tag表的实体类 标签
 * @createTime 25/09/2023 3:43 pm
 */
public class Tag {

    //标签id
    private int oId;

    //标签被引用次数
    private int referenceCount;

    //标签名称
    private String title;


    public Tag() {
    }

    public Tag(int oId, int referenceCount, String title) {
        this.oId = oId;
        this.referenceCount = referenceCount;
        this.title = title;
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
     * @return referenceCount
     */
    public int getReferenceCount() {
        return referenceCount;
    }

    /**
     * 设置
     * @param referenceCount
     */
    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
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

    public String toString() {
        return "Tag{oId = " + oId + ", referenceCount = " + referenceCount + ", title = " + title + "}";
    }
}
