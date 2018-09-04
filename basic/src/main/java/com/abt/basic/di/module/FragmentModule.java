package com.abt.basic.di.module;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.abt.basic.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * @描述： @FragmentModule
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
@Module
public class FragmentModule {

    private Fragment fragment;
    private DialogFragment dialogFragment;

    public FragmentModule(Fragment fragment) {
        this.dialogFragment = null;
        this.fragment = fragment;
    }

    public FragmentModule(DialogFragment fragment) {
        this.fragment = null;
        this.dialogFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        if (fragment == null) {
            return dialogFragment.getActivity();
        } else {
            return fragment.getActivity();
        }
    }

}
