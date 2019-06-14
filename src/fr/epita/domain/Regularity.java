package fr.epita.domain;

public class Regularity {
	private Integer year;
	private Integer month;
	private String region;
	
	// regularity as percentage
	private Double regularity;
	
	// punctuality as percentage
	private Double punctuality;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getRegularity() {
		return regularity;
	}

	public void setRegularity(Double regularity) {
		this.regularity = regularity;
	}

	public Double getPunctuality() {
		return punctuality;
	}

	public void setPunctuality(Double punctuality) {
		this.punctuality = punctuality;
	}
}
