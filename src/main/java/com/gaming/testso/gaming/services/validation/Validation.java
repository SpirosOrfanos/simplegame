package com.gaming.testso.gaming.services.validation;

import com.gaming.testso.gaming.context.GameContext;
import com.gaming.testso.gaming.exceptions.GameException;

public abstract class Validation <A>{

	public void exec(GameContext context, A a) throws GameException {
		validate(context, a);
	}
	abstract void validate(GameContext context, A a) throws GameException;
}
