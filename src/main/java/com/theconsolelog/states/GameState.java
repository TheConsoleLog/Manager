package com.theconsolelog.states;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameState {

	@Getter @Setter
	private String name;
	private final List<Object> values;

	public GameState (String name) {
		this.name = name;
		this.values = new ArrayList<> ();
	}

	public void addValues (Object... values) {
		this.values.addAll (Arrays.asList (values));
	}

	public void addValues (List<Object> values) {
		this.values.addAll (values);
	}
}
