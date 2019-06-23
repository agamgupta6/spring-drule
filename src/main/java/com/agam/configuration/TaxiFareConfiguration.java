package com.agam.configuration;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.agam.utils.KieUtils;

@Configuration
public class TaxiFareConfiguration {
	private static final String drlFile = "TAXI_FARE_RULE.drl";

	@Bean
	@ConditionalOnMissingBean(KieContainer.class)
	public KieContainer kieContainer() {

		KieServices kieServices = getKieServices();
		KieContainer kieContainer = kieServices.newKieContainer(getKieModule().getReleaseId());
		KieUtils.setKieContainer(kieContainer);
		return kieContainer;
	}

	@Bean
	@ConditionalOnMissingBean(KieModule.class)
	public KieModule getKieModule() {
		KieServices kieServices = getKieServices();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		return kieModule;
	}

	@Bean
	@ConditionalOnMissingBean(KieServices.class)
	public KieServices getKieServices() {
		KieServices kieServices = KieServices.Factory.get();
		return kieServices;
	}
	
	
	
}