package io.github.lpedrosa.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Game {

	private final long gameId;
	private final String currentWord;
	private final Map<String, List<Integer>> uncoveredByPostion;
	private final int livesLeft;

	public Game(final long gameId,
				final String currentWord,
				final Map<String, List<Integer>> uncoveredByPostion,
				final int livesLeft) {
		this.gameId = gameId;
		this.currentWord = currentWord;
		this.uncoveredByPostion = uncoveredByPostion;
		this.livesLeft = livesLeft;
	}

	public Game tryLetter(final char letter) {
		if (this.isFinished())
			return this;


		return null;
	}

	public boolean isFinished() {
		final boolean guessedAllLetters = this.currentWord.chars().distinct().count() == this.uncoveredByPostion.keySet().size();
		final boolean noLivesLeft = this.livesLeft == 0;
		return noLivesLeft || guessedAllLetters;
	}

	public long getGameId() {
		return this.gameId;
	}

	public String getCurrentWord() {
		return this.currentWord;
	}

	public Map<String, List<Integer>> getUncoveredByPostion() {
		return Collections.unmodifiableMap(this.uncoveredByPostion);
	}

	public int getLivesLeft() {
		return this.livesLeft;
	}

}
