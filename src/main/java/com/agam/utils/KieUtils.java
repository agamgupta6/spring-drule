package com.agam.utils;

import org.kie.api.runtime.KieContainer;

public class KieUtils {

	private static KieContainer kieContainer;

	public static void setKieContainer(KieContainer kieContainer) {
		KieUtils.kieContainer = kieContainer;
	}

	public static KieContainer getKieContainer() {
		return KieUtils.kieContainer;
	}

}
