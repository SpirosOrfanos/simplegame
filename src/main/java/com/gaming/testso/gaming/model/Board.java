package com.gaming.testso.gaming.model;

import com.gaming.testso.gaming.actions.GameAction;

public class Board {

	public void accept(GameAction action) {
		//String.join(":", action.getAction(), action.getStatus().toString());
		System.out.println(String.join(":", action.getAction(), action.getStatus().toString()));
	}
}
