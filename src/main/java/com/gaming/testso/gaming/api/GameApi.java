package com.gaming.testso.gaming.api;

import com.gaming.testso.gaming.exceptions.GameException;

public interface GameApi {

	public boolean acceptAndFire(String command)  throws GameException;
}
