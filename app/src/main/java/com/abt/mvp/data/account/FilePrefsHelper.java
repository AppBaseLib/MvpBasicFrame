package com.abt.mvp.data.account;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * 界面调用：<br>
 * FilePrefsHelper preferences = FilePrefsHelper.Factory.getInstance(this); <br>
 * String accountId = preferences.getAccountId();
 */
public interface FilePrefsHelper {

	SharedPreferences getSharedPreferences();

	/**
	 * 获取保存的数据
	 */
	<T> T get(Context context, String key, Class<T> c);

	/**
	 * 保存数据，持久化
	 */
	boolean save(Context context, String key, Serializable obj);

	void setAccountId(String accountId);

	String getAccountId();

	String getToken();

	void setToken(String token);

	final class Factory {
		public static final FilePrefsHelper getInstance(Context context) {
			return MemoPrefsImpl.getInstance(context);
		}
	}
}
