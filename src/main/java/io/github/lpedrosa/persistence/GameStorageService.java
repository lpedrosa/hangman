package io.github.lpedrosa.persistence;

import io.github.lpedrosa.domain.Game;

public interface GameStorageService {

    Game storeGame(final Game game) throws GameStorageException;
    Game loadGame(final String gameId) throws GameStorageException;

}
