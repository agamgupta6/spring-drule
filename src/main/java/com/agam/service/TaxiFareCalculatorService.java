package com.agam.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agam.fact.TaxiRide;
import com.agam.result.Fare;

@Service
public class TaxiFareCalculatorService {
 
    @Autowired
    private KieContainer kieContainer;
 
    public Long calculateFare(TaxiRide taxiRide, Fare rideFare) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();
        return rideFare.getTotalFare();
    }
}