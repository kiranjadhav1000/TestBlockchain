package com.blockchain.core;

public class Transaction {
	
	private String to;
	private String from;
	private float amt;
	
	public Transaction(String from,String to, float amt) {
		this.to=to;
		this.amt=amt;
		this.from=from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "\t Transaction [from=" + from + ", to=" + to + ", amt=" + amt+ " BTC] ";
	}
	
}
