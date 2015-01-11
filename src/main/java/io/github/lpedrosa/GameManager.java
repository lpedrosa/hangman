package io.github.lpedrosa;

import io.github.lpedrosa.domain.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GameManager {

    public Game guessLetter(final Game game, final char letter) {
        if (game.isFinished())
            return game;

        final char letterLower = Character.toLowerCase(letter);

        final List<Integer> letterPositions = allIndexesForLetter(game.getCurrentWord(), letterLower);

        if (letterPositions.isEmpty())
            return new Game(game.getGameId(),
                            game.getCurrentWord(),
                            game.getUncoveredByPostion(),
                            game.getLivesLeft()-1);

        final Map<String, List<Integer>> newUncoveredByPosition = new HashMap<>(game.getUncoveredByPostion());
        newUncoveredByPosition.put(String.valueOf(letterLower), letterPositions);

        return new Game(game.getGameId(),
                        game.getCurrentWord(),
                        newUncoveredByPosition,
                        game.getLivesLeft());
    }

    private List<Integer> allIndexesForLetter(final String word, final char letter) {
        final List<Integer> letterPositions = new ArrayList<>();

        final String currentWordLower = word.toLowerCase();

        int index = -1;
        do {
            index = currentWordLower.indexOf(letter, index+1);
            if (index != -1)
                letterPositions.add(index);
        } while(index != -1);

        return letterPositions;
    }
    // saveState :: Game -> Game, SaveStateException
    // loadState :: GameId -> Game, LoadStateException
    // listGames :: () -> Stream<Game>
}
