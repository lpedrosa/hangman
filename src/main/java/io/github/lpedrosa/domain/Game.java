package io.github.lpedrosa.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Game {
	
	private final long gameId;
	private final String currentWord;
	private final Map<String, List<Integer>> uncoveredByPostion;
	private final int livesLeft;

	public Game(long gameId,
				String currentWord,
				Map<String, List<Integer>> uncoveredByPostion, 
				int livesLeft) {
		this.gameId = gameId;
		this.currentWord = currentWord;
		this.uncoveredByPostion = uncoveredByPostion;
		this.livesLeft = livesLeft;
	}
	
	public long getGameId() {
		return gameId;
	}

	public String getCurrentWord() {
		return currentWord;
	}

	public Map<String, List<Integer>> getUncoveredByPostion() {
		return Collections.unmodifiableMap(uncoveredByPostion);
	}

	public int getLivesLeft() {
		return livesLeft;
	}
	
}
