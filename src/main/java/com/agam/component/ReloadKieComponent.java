package com.agam.component;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Component;

import com.agam.utils.KieUtils;

@Component
public class ReloadKieComponent {

	private static final String drlFile = "TAXI_FARE_RULE.drl";

	public String reloadKie() {

		KieServices kieServices = KieServices.Factory.get();

		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
		KieUtils.setKieContainer(kieContainer);

		return "done";

	}

}
