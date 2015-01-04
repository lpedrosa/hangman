package io.github.lpedrosa.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
        if (isFinished())
            return this;

        final List<Integer> letterPositions = allIndexesForLetter(letter);

        if (letterPositions.isEmpty())
            return new Game(this.gameId,
                            this.currentWord,
                            this.uncoveredByPostion,
                            this.livesLeft-1);

        final Map<String, List<Integer>> newUncoveredByPosition = new HashMap<>(this.uncoveredByPostion);
        newUncoveredByPosition.put(String.valueOf(letter), letterPositions);

        return new Game(this.gameId,
                        this.currentWord,
                        newUncoveredByPosition,
                        this.livesLeft);
    }

    private List<Integer> allIndexesForLetter(final char letter) {
        final List<Integer> letterPositions = new ArrayList<>();

        final String currentWordLower = this.currentWord.toLowerCase();

        int index = -1;
        do {
            index = currentWordLower.indexOf(letter, index+1);
            if (index != -1)
                letterPositions.add(index);
        } while(index != -1);

        return letterPositions;
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
