package com.abt.mvp.data.bean.main.search;

/**
 * @描述： @UsefulSiteData
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class UsefulSiteData {

    private int id;
    private String name;
    private String link;
    private int visible;
    private int order;
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
