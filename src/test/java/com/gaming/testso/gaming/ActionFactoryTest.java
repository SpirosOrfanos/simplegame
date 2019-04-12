package com.gaming.testso.gaming;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.exceptions.GameException;
import com.gaming.testso.gaming.services.actionfactory.ActionFactory;
import com.gaming.testso.gaming.services.actionfactory.ActionFactoryService;

@RunWith(JUnit4.class)
public class ActionFactoryTest {

	private ActionFactory actionFactory;
	@Before
	public void pre() {
		this.actionFactory = new ActionFactoryService();
	}
	@Test
	public void testRequestType() throws GameException {
		assertTrue("GamePlayerAction created", (actionFactory.accept("S South") instanceof GamePlayerAction));
	}
	@Test(expected=GameException.class)
	public void testInvalidRequestType() throws GameException {
		actionFactory.accept("P South");
	}
}
