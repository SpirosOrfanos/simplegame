package com.gaming.testso.gaming.services.validation;

import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.context.GameContext;
import com.gaming.testso.gaming.exceptions.GameException;

public class PlayerValidation extends Validation<GamePlayerAction>{

	@Override
	void validate(GameContext context, GamePlayerAction a) throws GameException {
		System.out.println("validate player");
		
	}

}
