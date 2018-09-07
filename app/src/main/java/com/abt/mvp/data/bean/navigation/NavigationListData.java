package com.abt.mvp.data.bean.navigation;

import com.abt.mvp.data.bean.main.collect.FeedArticleData;

import java.io.Serializable;
import java.util.List;

/**
 * @描述： @NavigationListData
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class NavigationListData implements Serializable {

    /**
     *    "articles": [],
     "cid": 272,
     "name": "常用网站"
     */

    private List<FeedArticleData> articles;
    private int cid;
    private String name;

    public List<FeedArticleData> getArticles() {
        return articles;
    }

    public void setArticles(List<FeedArticleData> articles) {
        this.articles = articles;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
