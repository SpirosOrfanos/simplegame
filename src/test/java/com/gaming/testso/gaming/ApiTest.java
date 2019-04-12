package com.gaming.testso.gaming;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.api.GameApi;
import com.gaming.testso.gaming.api.GameApiService;
import com.gaming.testso.gaming.constants.GameStateEnum;
import com.gaming.testso.gaming.context.GameContext;
import com.gaming.testso.gaming.exceptions.GameException;
import com.gaming.testso.gaming.services.actionfactory.ActionFactory;
import com.gaming.testso.gaming.services.actionfactory.ActionFactoryService;
import com.gaming.testso.gaming.services.state.StateListener;
import com.gaming.testso.gaming.services.state.StateListenerService;
import com.gaming.testso.gaming.services.validation.GameValidation;
import com.gaming.testso.gaming.services.validation.PlayerValidation;
import com.gaming.testso.gaming.services.validation.Validation;

@RunWith(JUnit4.class)
public class ApiTest {

	private static GameApi api;
	@BeforeClass
	public static void pre() {
		api = new GameApiService(new ActionFactoryService(), 
				new PlayerValidation(), new GameValidation(), new StateListenerService());
	}
	
	@Test
	public void sendStartCommandBasic() throws GameException {
		api.acceptAndFire("E starting game");
		
	}
	@Test(expected=GameException.class)
	public void sendStartCommandError() throws GameException {
		api.acceptAndFire("E starting game");
		
	}
}
