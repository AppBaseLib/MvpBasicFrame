package com.abt.mvp.data.account;

import android.content.Context;

/**
 * 内存存储，如果只需存内存，直接重写具体方法即可
 */
public class MemoPrefsImpl extends FilePrefsImpl {

	private static FilePrefsHelper mPre;

	protected MemoPrefsImpl(Context context) {
		super(context);		
	}

	public static synchronized final FilePrefsHelper getInstance(Context context) {
		if (mPre == null) {
			mPre = new MemoPrefsImpl(context.getApplicationContext());
		}
		return mPre;
	}

}
