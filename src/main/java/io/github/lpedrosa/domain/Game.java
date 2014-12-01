package io.github.lpedrosa.domain;

import java.util.List;
import java.util.Map;

public final class Game {
	private final String currentWord;
	private final Map<String, List<Integer>> uncoveredByPostion;
	private final int livesLeft;

	public Game(String currentWord,
				Map<String, List<Integer>> uncoveredByPostion, 
				int livesLeft) {
		this.currentWord = currentWord;
		this.uncoveredByPostion = uncoveredByPostion;
		this.livesLeft = livesLeft;
	}
	
}
