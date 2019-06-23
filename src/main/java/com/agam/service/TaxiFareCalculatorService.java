package com.agam.service;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.agam.fact.TaxiRide;
import com.agam.result.Fare;
import com.agam.utils.KieUtils;

@Service
public class TaxiFareCalculatorService {

	public Long calculateFare(TaxiRide taxiRide, Fare rideFare) {
		KieSession kieSession = KieUtils.getKieContainer().newKieSession();
		kieSession.setGlobal("rideFare", rideFare);
		kieSession.insert(taxiRide);
		kieSession.fireAllRules();
		kieSession.dispose();
		return rideFare.getTotalFare();
	}
}