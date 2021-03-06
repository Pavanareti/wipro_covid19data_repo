package com.covid19.dto;

public class Status {
	private Integer covid19DataId;
	public Integer getCovid19DataId() {
		return covid19DataId;
	}
	public void setCovid19DataId(Integer covid19DataId) {
		this.covid19DataId = covid19DataId;
	}
	private String city;
	private String province;
	private String country;
	private String lastUpdate;
	private String keyId;
	private int confirmed;
	private int deaths;
	private String recovered;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public int getConfirmed() {
		return confirmed;
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

}
