package com.gaming.testso.gaming.api;

import java.util.UUID;

import com.gaming.testso.gaming.actions.GameAction;
import com.gaming.testso.gaming.actions.GameCreatePlayerAction;
import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.constants.GameStateEnum;
import com.gaming.testso.gaming.context.GameContext;
import com.gaming.testso.gaming.exceptions.GameException;
import com.gaming.testso.gaming.model.Game;
import com.gaming.testso.gaming.model.Player;
import com.gaming.testso.gaming.services.actionfactory.ActionFactory;
import com.gaming.testso.gaming.services.state.StateListener;
import com.gaming.testso.gaming.services.validation.Validation;

public class GameApiService implements GameApi{
	private GameContext context ;
	private ActionFactory actionFactory;
	private Validation<GamePlayerAction> playerValidation;
	private Validation<GameStateAction>  gameValidation;
	private StateListener stateListener;
	public GameApiService(ActionFactory actionFactory,
			Validation <GamePlayerAction> playerValidation, 
			Validation <GameStateAction> gameValidation,
			StateListener stateListener) {
		this.playerValidation = playerValidation;
		this.gameValidation = gameValidation;
		this.actionFactory = actionFactory;
		this.stateListener = stateListener;
		
		init();
		
	}
	private void init() {

			context = new GameContext();
			new Game(context,UUID.randomUUID().toString()); 
			context.setGameState(GameStateEnum.INIT);

	}
	@Override
	public boolean acceptAndFire(String command) throws GameException {
		GameAction action = actionFactory.accept(command);
		
		if(action.getStatus().equals(GameStateEnum.QUIT))
			return false;
		
		if(action instanceof GamePlayerAction) {
			playerValidation.exec(this.context, (GamePlayerAction)action);
			stateListener.setState(context, (GamePlayerAction) action);
		} else if(action instanceof GameStateAction) {
			gameValidation.exec(this.context, (GameStateAction)action);
			stateListener.setState(context, (GameStateAction) action);
		}
		
		if(action instanceof GameCreatePlayerAction)
			new Player(context, action.getAction());
		
		context.acceptAction(action);
		
		return true;
	}

}
