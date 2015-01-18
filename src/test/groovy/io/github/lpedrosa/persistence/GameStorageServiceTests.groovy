package io.github.lpedrosa.persistence;

import static org.junit.Assert.fail
import io.github.lpedrosa.domain.Game
import spock.lang.Specification

class GameStorageServiceTests extends Specification {

    GameStorageService gameStorageService = new SimpleGameStorageService()

    def "storing a new game should return same game"() {
        given:
            def game = Game.newGameFor("word", 3)
        when:
            def updatedGame = gameStorageService.storeGame(game)
        then:
            updatedGame.gameId == game.gameId
            updatedGame.currentWord == game.currentWord
    }

    def "storing a game should merge correctly with possible state"() {
        given:
            def game = new Game("id", "word", ["w":1], 3)
            gameStorageService.storeGame(game)
        when:
            def anotherGame = new Game("id", "word", ["w":1], 2)
            def updatedGame = gameStorageService.storeGame(anotherGame)
        then:
            updatedGame.gameId == game.gameId
            updatedGame.currentWord == game.currentWord
            updatedGame.livesLeft == anotherGame.livesLeft
    }

    def "storing a game should throw when merging with an impossible state"() {
        given:
            def game = new Game("id", "word", ["w":1], 1)
            gameStorageService.storeGame(game)
        when:
            def anotherGame = new Game("id", "word", ["w":1], 2)
            def updatedGame = gameStorageService.storeGame(anotherGame)
        then:
            thrown(GameStorageException)
    }

    def "loading an existing game should work"() {
        given:
            def game = Game.newGameFor("word", 3)
            gameStorageService.storeGame(game)
            def gameId = game.gameId
        when:
            Game loadedGame = gameStorageService.loadGame(gameId)
        then:
            loadedGame.gameId == game.gameId
            loadedGame.currentWord == game.currentWord
    }

    def "loading a non existant game should throw"() {
        given:
            def bogusId = "bogus"
        when:
            gameStorageService.loadGame(bogusId)
        then:
            thrown(GameStorageException)
    }

}
