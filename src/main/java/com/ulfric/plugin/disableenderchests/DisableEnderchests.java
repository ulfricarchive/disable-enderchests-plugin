package com.ulfric.plugin.disableenderchests;

import com.ulfric.plugin.Plugin;

public class DisableEnderchests extends Plugin {

	public DisableEnderchests() {
		install(DisableEnderchestsListener.class);
	}

}
