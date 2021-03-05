package com.theconsolelog.states;

import java.util.ArrayList;
import java.util.List;

public class StateManager {

	private final List<GameState> gameStates;
	private GameState currentState;

	public StateManager () {
		this.gameStates = new ArrayList<> ();
	}

	public void addState(GameState state) {
		this.gameStates.add (state);
	}

	public ArrayList<GameState> getStates () {
		return (ArrayList<GameState>) this.gameStates;
	}

	public boolean isEmpty () {
		return gameStates.isEmpty ();
	}

	public boolean isCurrentState () {
		return currentState != null;
	}

	public void setCurrentState (GameState state) {
		this.currentState = state;
	}

	public GameState getCurrentState () {
		if (!isCurrentState ()) return null;
		return this.currentState;
	}
}
