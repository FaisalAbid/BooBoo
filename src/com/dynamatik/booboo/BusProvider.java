package com.dynamatik.booboo;

import com.squareup.otto.Bus;

public class BusProvider {

	private static final Bus BUS = new Bus();

	public static Bus getInstance() {
		return BUS;
	}
}