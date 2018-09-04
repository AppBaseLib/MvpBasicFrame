package com.abt.basic.di.component;

import android.app.Activity;

import com.abt.basic.di.module.ActivityModule;
import com.abt.basic.di.scope.ActivityScope;

import dagger.Component;

/**
 * @描述： @ActivityComponent
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();

    /**
     * 注入MAinActivity所需的依赖
     *
     * @param mainActivity MainActivity
     */
//    void inject(MainActivity mainActivity);

    /**
     * 注入SplashActivity所需的依赖
     *
     * @param splashActivity SplashActivity
     */
//    void inject(SplashActivity splashActivity);

    /**
     * 注入ArticleDetailActivity所需的依赖
     *
     * @param articleDetailActivity ArticleDetailActivity
     */
//    void inject(ArticleDetailActivity articleDetailActivity);

    /**
     * 注入KnowledgeHierarchyDetailActivity所需的依赖
     *
     * @param knowledgeHierarchyDetailActivity KnowledgeHierarchyDetailActivity
     */
//    void inject(KnowledgeHierarchyDetailActivity knowledgeHierarchyDetailActivity);

    /**
     * 注入LoginActivity所需的依赖
     *
     * @param loginActivity LoginActivity
     */
//    void inject(LoginActivity loginActivity);

    /**
     * 注入CollectActivity所需的依赖
     *
     * @param collectActivity CollectActivity
     */
//    void inject(CollectActivity collectActivity);

    /**
     * 注入AboutUsActivity所需的依赖
     *
     * @param aboutUsActivity AboutUsActivity
     */
//    void inject(AboutUsActivity aboutUsActivity);

    /**
     * 注入SearchListActivity所需的依赖
     *
     * @param searchListActivity SearchListActivity
     */
//    void inject(SearchListActivity searchListActivity);

}
