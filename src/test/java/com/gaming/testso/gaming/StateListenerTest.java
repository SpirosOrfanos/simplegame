package com.gaming.testso.gaming;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.constants.GameStateEnum;
import com.gaming.testso.gaming.context.GameContext;
import com.gaming.testso.gaming.exceptions.GameException;
import com.gaming.testso.gaming.services.actionfactory.ActionFactory;
import com.gaming.testso.gaming.services.actionfactory.ActionFactoryService;
import com.gaming.testso.gaming.services.state.StateListener;
import com.gaming.testso.gaming.services.state.StateListenerService;
import com.gaming.testso.gaming.services.validation.GameValidation;
import com.gaming.testso.gaming.services.validation.Validation;

@RunWith(JUnit4.class)
public class StateListenerTest {

	private StateListener stateListener;
	private Validation<GameStateAction> gameValidator;
	private GameContext context; 
	private GameStateAction action;
	@Before
	public void pre() {
		this.stateListener = new StateListenerService();
		context = new GameContext();
		context.setGameState(GameStateEnum.INIT);
		action = new GameStateAction("an action", GameStateEnum.SAVE);
		gameValidator = new GameValidation();
		
	}
	@Test
	public void testStateType() throws GameException {
		stateListener.setState(context, action);
		assertTrue(context.getGameState().ordinal() == 2);
	}
	@Test(expected=GameException.class)
	public void testValidationError() throws GameException {
		context.setGameState(GameStateEnum.START);
		action = new GameStateAction("an action", GameStateEnum.START);
		gameValidator.exec(context, action);
	}
	@Test
	public void testValidation() throws GameException {
		gameValidator.exec(context, action);
	}
}
