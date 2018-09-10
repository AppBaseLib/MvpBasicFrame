package com.abt.mvp.data.account;

/**
 * 内存存储，如果只需存内存，直接重写具体方法即可
 */
public class MemoPrefsImpl extends FilePrefsImpl {

	private static FilePrefsHelper mPre;

	protected MemoPrefsImpl() {
		super();
	}

	public static synchronized final FilePrefsHelper getInstance() {
		if (mPre == null) {
			mPre = new MemoPrefsImpl();
		}
		return mPre;
	}

}
