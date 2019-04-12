package com.gaming.testso.gaming.services.actionfactory;

import com.gaming.testso.gaming.actions.GameAction;
import com.gaming.testso.gaming.exceptions.GameException;

public interface ActionFactory {
	public GameAction accept(String input) throws GameException;
}
