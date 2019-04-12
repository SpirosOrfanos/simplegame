package com.gaming.testso.gaming.context;
import java.util.*;

import com.gaming.testso.gaming.actions.GameAction;
import com.gaming.testso.gaming.constants.GameStateEnum;
import com.gaming.testso.gaming.model.GameItem;
public class GameContext {

	private List<GameItem> items = new ArrayList<>();
	private GameStateEnum gameState;
	private GameStateEnum playerState;
	public void attach(GameItem item) {
		items.add(item);
	}
	public void acceptAction(GameAction action) {
		items.stream().forEach(item -> item.accept(action));
	}
	public GameStateEnum getGameState() {
		return gameState;
	}
	
	public GameStateEnum getPlayerState() {
		return playerState;
	}
	public void setPlayerState(GameStateEnum playerState) {
		this.playerState = playerState;
	}
	public void setGameState(GameStateEnum gameState) {
		this.gameState = gameState;
	}
	
	
	
}
