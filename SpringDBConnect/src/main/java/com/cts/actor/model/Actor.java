package com.cts.actor.model;

import java.sql.Date;

public class Actor {
	private int actorId;
	private String actorName;
	private Date price;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Date getPrice() {
		return price;
	}

	public void setPrice(Date price) {
		this.price = price;
	}
}
