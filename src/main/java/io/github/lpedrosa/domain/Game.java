package io.github.lpedrosa.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class Game {

    private final String gameId;
    private final String currentWord;
    private final Map<String, List<Integer>> uncoveredByPostion;
    private final int livesLeft;

    public static Game newGameFor(final String word, final int lives) {
        return new Game(UUID.randomUUID().toString(), word, new HashMap<String, List<Integer>>(), lives);
    }

    public Game(final String gameId,
                final String currentWord,
                final Map<String, List<Integer>> uncoveredByPostion,
                final int livesLeft) {
        this.gameId = gameId;
        this.currentWord = currentWord;
        this.uncoveredByPostion = uncoveredByPostion;
        this.livesLeft = livesLeft;
    }

    public boolean isFinished() {
        final boolean guessedAllLetters = this.currentWord.chars().distinct().count() == this.uncoveredByPostion.keySet().size();
        final boolean noLivesLeft = this.livesLeft == 0;
        return noLivesLeft || guessedAllLetters;
    }

    public String getGameId() {
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
