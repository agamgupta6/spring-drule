package com.agam.fact;
public class TaxiRide {
    private Boolean isNightSurcharge;
    private Long distanceInMile;
	public TaxiRide(boolean isNight, Long distance) {
		this.isNightSurcharge  = isNight;
		this.distanceInMile = distance;
	}
	public Boolean getIsNightSurcharge() {
		return isNightSurcharge;
	}
	public void setIsNightSurcharge(Boolean isNightSurcharge) {
		this.isNightSurcharge = isNightSurcharge;
	}
	public Long getDistanceInMile() {
		return distanceInMile;
	}
	public void setDistanceInMile(Long distanceInMile) {
		this.distanceInMile = distanceInMile;
	}
     
    
}