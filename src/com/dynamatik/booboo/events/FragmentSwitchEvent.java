package com.dynamatik.booboo.events;

import android.support.v4.app.Fragment;

public class FragmentSwitchEvent {

	private Fragment mToFragment;
	private String mTag;
	private boolean mClearBackStack = false;

	public FragmentSwitchEvent(Fragment toFragment) {
		mToFragment = toFragment;
		mTag = toFragment.getClass().getName();
	}

	public FragmentSwitchEvent(Fragment toFragment, boolean clearBackStack) {
		mToFragment = toFragment;
		mTag = toFragment.getClass().getName();
		mClearBackStack = clearBackStack;
	}

	public Fragment getFragment() {
		return mToFragment;
	}

	public String getTag() {
		return mTag;
	}

	public boolean isClearBackStack() {
		return mClearBackStack;
	}

}
