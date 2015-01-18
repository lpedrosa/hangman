package io.github.lpedrosa.persistence;

import io.github.lpedrosa.common.ServiceException;
import io.github.lpedrosa.domain.Game;

public interface GameStorageService {

    /**
     * Stores the given game state. It returns the most up to
     * date state. This means that it will try to merge the given
     * game state with an already existing one.
     *
     * When trying to merge with an existing state, this may generate
     * an illegal result (e.g. game with negative lives).
     * When this merge operation leads to an illegal state, this method
     * will throw a {@link GameStorageException}.
     *
     * It may also throw a {@link ServiceException} if the underlying
     * persistence unit fails to store the game state (e.g. network timeout)
     *
     * @param game the game to store
     * @return the most up to date game state
     * @throws GameStorageException when merging game states led
     * to an illegal state
     * @throws ServiceException when the underlying persistence unit fails
     * to store the game state
     */
    Game storeGame(final Game game) throws GameStorageException, ServiceException;

    /**
     * Loads a game with the given game id. If the game does not exist it
     * throws a {@link GameStorageException}
     * @param gameId the id of the game to load
     * @return the most up to date game state for the given id
     * @throws GameStorageException if the no game with the given id exists
     * @throws ServiceException when the underlying persistence unit fails
     * to store the game state
     */
    Game loadGame(final String gameId) throws GameStorageException, ServiceException;

}
