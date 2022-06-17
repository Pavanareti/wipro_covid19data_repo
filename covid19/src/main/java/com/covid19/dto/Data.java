package com.covid19.dto;

import java.util.List;

public class Data {

	private String lastChecked;
	private List<Status> covid19Stats;
	public String getLastChecked() {
		return lastChecked;
	}
	public void setLastChecked(String lastChecked) {
		this.lastChecked = lastChecked;
	}
	public List<Status> getCovid19Stats() {
		return covid19Stats;
	}
	public void setCovid19Stats(List<Status> covid19Stats) {
		this.covid19Stats = covid19Stats;
	}
}
