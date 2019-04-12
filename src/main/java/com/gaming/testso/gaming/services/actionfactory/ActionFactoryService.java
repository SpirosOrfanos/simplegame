package com.gaming.testso.gaming.services.actionfactory;

import com.gaming.testso.gaming.actions.GameAction;
import com.gaming.testso.gaming.actions.GameCreatePlayerAction;
import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.constants.ActionConfig;
import com.gaming.testso.gaming.exceptions.GameException;
import com.gaming.testso.gaming.services.validation.AppStringUtils;

public class ActionFactoryService implements ActionFactory{
	

	public GameAction accept(String input) throws GameException {
		String[] options = input.split(" ");
		ActionConfig action = ActionConfig.getByShortcut(options[0]);
		switch(action) {
			case FIGHT :
			case MOVE :
				return new GamePlayerAction(AppStringUtils.join(action.getDescription(), options[0]), action.getStatus());
			case SAVE :
			case QUIT :
			case START:
			case STOP :
				return new GameStateAction(AppStringUtils.join(action.getDescription(), options[0]), action.getStatus());
				
			case CREATEPLAYER: 
				return new GameCreatePlayerAction(options[1], action.getStatus());
				
			default: throw new GameException("Invalid action");
		}
	}
	

}
