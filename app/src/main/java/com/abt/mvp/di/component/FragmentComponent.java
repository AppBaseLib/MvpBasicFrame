package com.abt.mvp.di.component;

import android.app.Activity;

import com.abt.mvp.di.module.FragmentModule;
import com.abt.mvp.di.scope.FragmentScope;

import dagger.Component;

/**
 * @描述： @FragmentComponent
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    /**
     * 获取Activity实例
     */
    Activity getActivity();

    /**
     * 注入MainPagerFragment所需的依赖
     * @param mainPagerFragment MainPagerFragment
     */
//    void inject(MainPagerFragment mainPagerFragment);

    /**
     * 注入KnowledgeHierarchyFragment所需的依赖
     *
     * @param knowledgeHierarchyFragment KnowledgeHierarchyFragment
     */
//    void inject(KnowledgeHierarchyFragment knowledgeHierarchyFragment);

    /**
     * 注入KnowledgeHierarchyListFragment所需的依赖
     * @param knowledgeHierarchyListFragment KnowledgeHierarchyListFragment
     */
//    void inject(KnowledgeHierarchyListFragment knowledgeHierarchyListFragment);

    /**
     * 注入VideoFrequencyFragment所需的依赖
     *
     * @param projectFragment ProjectFragment
     */
//    void inject(ProjectFragment projectFragment);

    /**
     * 注入NewsFragment所需的依赖
     *
     * @param navigationFragment NavigationFragment
     */
//    void inject(NavigationFragment navigationFragment);

    /**
     * 注入ProjectListFragment所需的依赖
     *
     * @param projectListFragment ProjectListFragment
     */
//    void inject(ProjectListFragment projectListFragment);

    /**
     * 注入ProjectListFragment所需的依赖
     *
     * @param searchDialogFragment SearchDialogFragment
     */
//    void inject(SearchDialogFragment searchDialogFragment);


}
