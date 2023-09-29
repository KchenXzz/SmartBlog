package com.kcx.extity;

/**
 * @author kcx
 * @version v1.0.0
 * @description 友情链接实体类
 * @createTime 26/09/2023 10:07 am
 */
public class Link {

    private int oId;

    private String address;

    private String description;

    private int order;

    private String title;


    public Link() {
    }

    public Link(String address, String title) {
        this.address = address;
        this.title = title;
    }

    public Link(int oId, String address, String description, int order, String title) {
        this.oId = oId;
        this.address = address;
        this.description = description;
        this.order = order;
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * @return order
     */
    public int getOrder() {
        return order;
    }

    /**
     * 设置
     * @param order
     */
    public void setOrder(int order) {
        this.order = order;
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
        return "Link{oId = " + oId + ", address = " + address + ", description = " + description + ", order = " + order + ", title = " + title + "}";
    }
}
