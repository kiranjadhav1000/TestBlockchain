package com.blockchain.core;

import java.sql.Timestamp;

public class Transaction {
	
	private String to;
	private String from;
	private float amt;
	Timestamp timestamp;
	
	public Transaction(String from,String to, float amt,Timestamp timestamp) {
		this.to=to;
		this.amt=amt;
		this.from=from;
		this.timestamp=timestamp;
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

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "\t Transaction [from=" + from + ", to=" + to + ", amt=" + amt+ " BTC "+ "timestamp=" +timestamp +"] ";
	}
	
}
