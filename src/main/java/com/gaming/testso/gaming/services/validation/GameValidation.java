package com.gaming.testso.gaming.services.validation;

import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.constants.GameStateEnum;
import com.gaming.testso.gaming.context.GameContext;
import com.gaming.testso.gaming.exceptions.GameException;

public class GameValidation extends Validation<GameStateAction>{

	@Override
	void validate(GameContext context, GameStateAction a) throws GameException {
		if(context.getGameState().ordinal() == (GameStateEnum.START.ordinal()) && a.getStatus().ordinal() == (GameStateEnum.START.ordinal()))
			throw new GameException("Can not start while running");
		System.out.println("validate game");
		
	}

}
