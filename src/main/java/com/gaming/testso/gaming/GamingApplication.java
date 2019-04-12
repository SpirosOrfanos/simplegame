package com.gaming.testso.gaming;

import java.util.*;

import com.gaming.testso.gaming.api.GameApi;
import com.gaming.testso.gaming.api.GameApiService;
import com.gaming.testso.gaming.constants.ActionConfig;
import com.gaming.testso.gaming.exceptions.GameException;
import com.gaming.testso.gaming.services.actionfactory.ActionFactoryService;
import com.gaming.testso.gaming.services.state.StateListenerService;
import com.gaming.testso.gaming.services.validation.GameValidation;
import com.gaming.testso.gaming.services.validation.PlayerValidation;

public class GamingApplication {

	public static void main(String[] args) throws GameException  {		
		GamingApplication app = new GamingApplication();
		app.run();
	
	}
	public void run() throws GameException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Available actions");
		Arrays.stream(ActionConfig.values()).forEach(config -> {
			System.out.println(String.join(":", config.getShortCut(), config.getDescription()));
		});
		GameApi api = new GameApiService(new ActionFactoryService(), 
				new PlayerValidation(), new GameValidation(), new StateListenerService());
		boolean game = true;
		while(game) {
			try {
				game = api.acceptAndFire(keyboard.nextLine());
			} catch (GameException e) {
				System.out.println(e.getMessage());
			} 
		}
		keyboard.close();
	}
}

