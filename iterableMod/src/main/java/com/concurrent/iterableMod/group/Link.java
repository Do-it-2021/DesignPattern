package com.concurrent.iterableMod.group;

public class Link {

	private String fromId;
	
	private String toId;

	public Link(String fromId, String toId) {
		super();
		this.fromId = fromId;
		this.toId = toId;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}
}
