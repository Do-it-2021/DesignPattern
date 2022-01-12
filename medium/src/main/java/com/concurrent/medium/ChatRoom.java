package com.concurrent.medium;

import java.util.Date;

public class ChatRoom {

	public static void showMessage(UserTest user,String message) {
		
		System.out.println(new Date().toString()+" ["+user.getName()+"] :"+message);
		
	}
}
