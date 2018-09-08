package com.abt.mvp.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @描述： @ActivityScope
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
