package com.CovidTacker.CovidTracker;

public class Data {
	private String state;
	private String confirmed;
	private String recovered;
	private String active;
	private String deaths;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	@Override
	public String toString() {
		return "Data [state=" + state + ", confirmed=" + confirmed + ", recovered=" + recovered + ", active=" + active
				+ ", deaths=" + deaths + "]";
	}
	

}
