package com.concurrent.medium;

public class UserTest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserTest(String name) {
		super();
		this.name = name;
	}
	
	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
	
	
}
