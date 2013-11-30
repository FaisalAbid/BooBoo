package com.dynamatik.booboo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import com.dynamatik.booboo.events.FragmentSwitchEvent;
import com.squareup.otto.Subscribe;

public class Booboo extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle instance) {
		super.onCreate(instance);
		setContentView(R.layout.main);
	}

	@Override
	protected void onResume() {
		super.onResume();
		BusProvider.getInstance().register(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		BusProvider.getInstance().unregister(this);
	}

	@Subscribe
	public void onFragmentSwitch(FragmentSwitchEvent event) {
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = event.getFragment();

		if (event.isClearBackStack()) {

			for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
				fm.popBackStack();
			}
		}

		String fragmentTag = event.getTag();

		FragmentManager manager = getSupportFragmentManager();

		FragmentTransaction ft = manager.beginTransaction();
		ft.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right);

		ft.replace(R.id.content_frame, fragment, fragmentTag);
		ft.addToBackStack(fragmentTag);
		ft.commit();

	}
}
