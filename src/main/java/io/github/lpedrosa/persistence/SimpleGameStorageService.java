package io.github.lpedrosa.persistence;

import io.github.lpedrosa.domain.Game;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SimpleGameStorageService implements GameStorageService {

    private final ConcurrentMap<String, Game> storage;

    public SimpleGameStorageService() {
        this.storage = new ConcurrentHashMap<>();
    }

    @Override
    public Game storeGame(final Game game) throws GameStorageException {
        final String gameId = game.getGameId();

//        Game oldGame = this.storage.get(gameId);
//
//        // store a new game
//        if (oldGame == null) {
//            oldGame = this.storage.putIfAbsent(gameId, game);
//            return oldGame == null ? game : oldGame;
//        }
//
//        final boolean replaced = this.storage.replace(gameId, oldGame, game);
//        return replaced ? game : this.storage.get(gameId);
        return null;
    }

    @Override
    public Game loadGame(final String gameId) throws GameStorageException {
        Game game = this.storage.get(gameId);

        if (game == null)
            throw new GameStorageException("Tried to load a non existant game [id: " + gameId + "]");

        return game;
    }

}
