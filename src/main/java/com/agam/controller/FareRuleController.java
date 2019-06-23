package com.agam.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agam.component.ReloadKieComponent;
import com.agam.fact.TaxiRide;
import com.agam.result.Fare;
import com.agam.service.TaxiFareCalculatorService;

@RestController
public class FareRuleController {

	Logger log = LoggerFactory.getLogger(FareRuleController.class);

	@Autowired
	TaxiFareCalculatorService taxiFareCalculatorService;

	@Resource
	ReloadKieComponent reloadKieComponent;

	@GetMapping("/calculatefare")
	public Fare getFare(@RequestParam boolean isNight, @RequestParam Long distance) {
		log.info(" Going to calculate fare for distance: " + distance + " with night surcharge " + isNight);
		TaxiRide ride = new TaxiRide(isNight, distance);
		Fare rideFare = new Fare();
		Long totalCharge = taxiFareCalculatorService.calculateFare(ride, rideFare);
		log.info("The fare is : " + totalCharge);
		// return totalCharge;
		return rideFare;
	}

	@GetMapping("reload")
	public String reload() {
		return reloadKieComponent.reloadKie();
	}

}
