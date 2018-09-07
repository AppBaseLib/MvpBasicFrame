package com.abt.mvp.data.network;

import com.abt.mvp.data.bean.BaseResponse;
import com.abt.mvp.data.bean.hierarchy.KnowledgeHierarchyData;
import com.abt.mvp.data.bean.main.banner.BannerData;
import com.abt.mvp.data.bean.main.collect.FeedArticleListData;
import com.abt.mvp.data.bean.main.login.LoginData;
import com.abt.mvp.data.bean.main.search.TopSearchData;
import com.abt.mvp.data.bean.main.search.UsefulSiteData;
import com.abt.mvp.data.bean.navigation.NavigationListData;
import com.abt.mvp.data.bean.project.ProjectClassifyData;
import com.abt.mvp.data.bean.project.ProjectListData;

import java.util.List;

import io.reactivex.Observable;

/**
 * @描述： @HttpHelper
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public interface HttpHelper {

    /**
     * 获取feed文章列表
     *
     * @param pageNum 页数
     * @return feed文章列表被观察者
     */
    Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum);

    /**
     * 获取搜索的文章列表
     *
     * @param pageNum 页数
     * @param k 关键字
     * @return 搜索的文章列表
     */
    Observable<BaseResponse<FeedArticleListData>> getSearchList(int pageNum, String k);

    /**
     * 热搜
     * http://www.wanandroid.com//hotkey/json
     *
     * @return Observable<BaseResponse<List<TopSearchData>>>
     */
    Observable<BaseResponse<List<TopSearchData>>> getTopSearchData();

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     *
     * @return Observable<BaseResponse<List<UsefulSiteData>>>
     */
    Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites();

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     *
     * @return Observable<BaseResponse<List<KnowledgeHierarchyData>>>
     */
    Observable<BaseResponse<List<KnowledgeHierarchyData>>> getKnowledgeHierarchyData();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0?cid=60
     *
     * @param page page num
     * @param cid second page id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    Observable<BaseResponse<FeedArticleListData>> getKnowledgeHierarchyDetailData(int page, int cid);

    /**
     * 导航
     * http://www.wanandroid.com/navi/json
     *
     * @return Observable<BaseResponse<List<NavigationListData>>>
     */
    Observable<BaseResponse<List<NavigationListData>>> getNavigationListData();

    /**
     * 项目分类
     * http://www.wanandroid.com/project/tree/json
     *
     * @return Observable<BaseResponse<List<ProjectClassifyData>>>
     */
    Observable<BaseResponse<List<ProjectClassifyData>>> getProjectClassifyData();

    /**
     * 项目类别数据
     * http://www.wanandroid.com/project/list/1/json?cid=294
     *
     * @param page page num
     * @param cid second page id
     * @return Observable<BaseResponse<ProjectListData>>
     */
    Observable<BaseResponse<ProjectListData>> getProjectListData(int page, int cid);

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return Observable<BaseResponse<LoginData>>
     */
    Observable<BaseResponse<LoginData>> getLoginData(String username, String password);

    /**
     * 注册
     * http://www.wanandroid.com/user/register
     *
     * @param username user name
     * @param password password
     * @param rePassword re password
     * @return Observable<BaseResponse<LoginData>>
     */
    Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String rePassword);

    /**
     * 收藏站内文章
     * http://www.wanandroid.com/lg/collect/1165/json
     *
     * @param id article id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    Observable<BaseResponse<FeedArticleListData>> addCollectArticle(int id);

    /**
     * 收藏站外文章
     * http://www.wanandroid.com/lg/collect/add/json
     *
     * @param title title
     * @param author author
     * @param link link
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    Observable<BaseResponse<FeedArticleListData>> addCollectOutsideArticle(String title, String author, String link);

    /**
     * 获取收藏列表
     * http://www.wanandroid.com/lg/collect/list/0/json
     *
     * @param page page number
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    Observable<BaseResponse<FeedArticleListData>> getCollectList(int page);

    /**
     * 取消收藏页面站内文章
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id article id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    Observable<BaseResponse<FeedArticleListData>> cancelCollectPageArticle(int id);

    /**
     * 取消站内文章
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id article id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    Observable<BaseResponse<FeedArticleListData>> cancelCollectArticle(int id);

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return Observable<BaseResponse<List<BannerData>>>
     */
    Observable<BaseResponse<List<BannerData>>> getBannerData();

    void login(String username, String password);

    void register(String username, String password, String repassword);

}
