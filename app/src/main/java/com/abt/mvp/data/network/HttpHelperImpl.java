package com.abt.mvp.data.network;

import com.abt.mvp.app.MvpApplication;
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
import com.abt.mvp.data.network.api.GeeksApis;
import com.abt.mvp.data.network.api.WebApis;

import java.util.List;

import io.reactivex.Observable;

/**
 * @描述： @HttpHelperImpl
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class HttpHelperImpl implements HttpHelper {

    private GeeksApis mGeeksApis;

    //@Inject
    public HttpHelperImpl() {
        mGeeksApis = ((MvpApplication)MvpApplication.getAppContext()).getGeeksApis();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum) {
        return mGeeksApis.getFeedArticleList(pageNum);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getSearchList(int pageNum, String k) {
        return mGeeksApis.getSearchList(pageNum, k);
    }

    @Override
    public Observable<BaseResponse<List<TopSearchData>>> getTopSearchData() {
        return mGeeksApis.getTopSearchData();
    }

    @Override
    public Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites() {
        return mGeeksApis.getUsefulSites();
    }

    @Override
    public Observable<BaseResponse<List<KnowledgeHierarchyData>>> getKnowledgeHierarchyData() {
        return mGeeksApis.getKnowledgeHierarchyData();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getKnowledgeHierarchyDetailData(int page, int cid) {
        return mGeeksApis.getKnowledgeHierarchyDetailData(page, cid);
    }

    @Override
    public Observable<BaseResponse<List<NavigationListData>>> getNavigationListData() {
        return mGeeksApis.getNavigationListData();
    }

    @Override
    public Observable<BaseResponse<List<ProjectClassifyData>>> getProjectClassifyData() {
        return mGeeksApis.getProjectClassifyData();
    }

    @Override
    public Observable<BaseResponse<ProjectListData>> getProjectListData(int page, int cid) {
        return mGeeksApis.getProjectListData(page, cid);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getLoginData(String username, String password) {
        return mGeeksApis.getLoginData(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String repassword) {
        return mGeeksApis.getRegisterData(username, password, repassword);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectArticle(int id) {
        return mGeeksApis.addCollectArticle(id);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectOutsideArticle(String title, String author, String link) {
        return mGeeksApis.addCollectOutsideArticle(title, author, link);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getCollectList(int page) {
        return mGeeksApis.getCollectList(page);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectPageArticle(int id) {
        return mGeeksApis.cancelCollectPageArticle(id, -1);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectArticle(int id) {
        return mGeeksApis.cancelCollectArticle(id, -1);
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mGeeksApis.getBannerData();
    }

    private WebApis mWebApis;

    //@Inject TODO 用Dagger来放开这个注解
    HttpHelperImpl(WebApis webApis) {
        mWebApis = webApis;
    }

    @Override
    public void login(String username, String password) {
        mWebApis.getLoginData(username, password);
    }

    @Override
    public void register(String username, String password, String repassword) {
        mWebApis.getRegisterData(username, password, repassword);
    }

}
