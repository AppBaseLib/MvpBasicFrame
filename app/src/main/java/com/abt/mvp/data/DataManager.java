package com.abt.mvp.data;

import android.content.Context;
import android.content.SharedPreferences;

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
import com.abt.mvp.data.dao.HistoryData;
import com.abt.mvp.data.db.DbHelper;
import com.abt.mvp.data.file.FileHelper;
import com.abt.mvp.data.network.HttpHelper;
import com.abt.mvp.data.account.FilePrefsHelper;
import com.abt.mvp.data.prefs.PreferenceHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * @描述： @DataManager
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class DataManager implements HttpHelper, DbHelper, FileHelper,
        PreferenceHelper, FilePrefsHelper {

    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private FileHelper mFileHelper;
    private FilePrefsHelper mFilePrefsHelper;
    private PreferenceHelper mPrefsHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, FileHelper fileHelper,
                       PreferenceHelper preferenceHelper, FilePrefsHelper prefsHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mFileHelper = fileHelper;
        mFilePrefsHelper = prefsHelper;
        mPrefsHelper = preferenceHelper;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum) {
        return mHttpHelper.getFeedArticleList(pageNum);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getSearchList(int pageNum, String k) {
        return mHttpHelper.getSearchList(pageNum, k);
    }

    @Override
    public Observable<BaseResponse<List<TopSearchData>>> getTopSearchData() {
        return mHttpHelper.getTopSearchData();
    }

    @Override
    public Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites() {
        return mHttpHelper.getUsefulSites();
    }

    @Override
    public Observable<BaseResponse<List<KnowledgeHierarchyData>>> getKnowledgeHierarchyData() {
        return mHttpHelper.getKnowledgeHierarchyData();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getKnowledgeHierarchyDetailData(int page, int cid) {
        return mHttpHelper.getKnowledgeHierarchyDetailData(page, cid);
    }

    @Override
    public Observable<BaseResponse<List<NavigationListData>>> getNavigationListData() {
        return mHttpHelper.getNavigationListData();
    }

    @Override
    public Observable<BaseResponse<List<ProjectClassifyData>>> getProjectClassifyData() {
        return mHttpHelper.getProjectClassifyData();
    }

    @Override
    public Observable<BaseResponse<ProjectListData>> getProjectListData(int page, int cid) {
        return mHttpHelper.getProjectListData(page, cid);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getLoginData(String username, String password) {
        return mHttpHelper.getLoginData(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String repassword) {
        return mHttpHelper.getRegisterData(username, password, repassword);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectArticle(int id) {
        return mHttpHelper.addCollectArticle(id);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectOutsideArticle(String title, String author, String link) {
        return mHttpHelper.addCollectOutsideArticle(title, author, link);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getCollectList(int page) {
        return mHttpHelper.getCollectList(page);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectArticle(int id) {
        return mHttpHelper.cancelCollectArticle(id);
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mHttpHelper.getBannerData();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectPageArticle(int id) {
        return mHttpHelper.cancelCollectPageArticle(id);
    }

    @Override
    public void setLoginAccount(String account) {
        mPrefsHelper.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mPrefsHelper.setLoginPassword(password);
    }

    @Override
    public String getLoginAccount() {
        return mPrefsHelper.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return mPrefsHelper.getLoginPassword();
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPrefsHelper.setLoginStatus(isLogin);
    }

    @Override
    public boolean getLoginStatus() {
        return mPrefsHelper.getLoginStatus();
    }

    @Override
    public void setCurrentPage(int position) {
        mPrefsHelper.setCurrentPage(position);
    }

    @Override
    public int getCurrentPage() {
        return mPrefsHelper.getCurrentPage();
    }

    @Override
    public void setProjectCurrentPage(int position) {
        mPrefsHelper.setProjectCurrentPage(position);
    }

    @Override
    public int getProjectCurrentPage() {
        return mPrefsHelper.getProjectCurrentPage();
    }


    @Override
    public List<HistoryData> addHistoryData(String data) {
        return mDbHelper.addHistoryData(data);
    }

    @Override
    public void clearHistoryData() {
        mDbHelper.clearHistoryData();
    }

    @Override
    public SharedPreferences getSharedPreferences() {
        return getSharedPreferences();
    }

    @Override
    public <T> T get(Context context, String key, Class<T> c) {
        return get(context, key, c);
    }

    @Override
    public boolean save(Context context, String key, Serializable obj) {
        return mFilePrefsHelper.save(context, key, obj);
    }

    @Override
    public void setAccountId(String accountId) {
        mFilePrefsHelper.setAccountId(accountId);
    }

    @Override
    public String getAccountId() {
        return mFilePrefsHelper.getAccountId();
    }

    @Override
    public String getToken() {
        return mFilePrefsHelper.getToken();
    }

    @Override
    public void setToken(String token) {
        mFilePrefsHelper.setToken(token);
    }

    @Override
    public void login(String username, String password) {
        mHttpHelper.login(username, password);
    }

    @Override
    public void register(String username, String password, String repassword) {
        mHttpHelper.register(username, password, repassword);
    }

    @Override
    public void saveStorage2SDCard(List arrayList, String fileName) {
        mFileHelper.saveStorage2SDCard(arrayList, fileName);
    }

    @Override
    public ArrayList getStorageEntities(String fileName) {
        return mFileHelper.getStorageEntities(fileName);
    }
}