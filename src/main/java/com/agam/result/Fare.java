package com.agam.result;

public class Fare {
	private Long nightSurcharge;
	private Long rideFare;

	public Long getNightSurcharge() {
		return nightSurcharge;
	}

	public void setNightSurcharge(Long nightSurcharge) {
		this.nightSurcharge = nightSurcharge;
	}

	public Long getRideFare() {
		return rideFare;
	}

	public void setRideFare(Long rideFare) {
		this.rideFare = rideFare;
	}

	public Long getTotalFare() {
		return this.rideFare + this.nightSurcharge;
	}

}