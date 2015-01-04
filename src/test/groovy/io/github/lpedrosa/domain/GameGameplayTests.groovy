package io.github.lpedrosa.domain;

import static org.junit.Assert.*
import spock.lang.*

class GameGameplayTests extends Specification {

    def "trying a letter when the game has finished"() {
        def game = new Game(0, "Lemons", [:], 0)
        char letter = 'w'

        when:
        def newGame = game.tryLetter(letter)

        then:
        newGame == game
    }

    def "trying a letter that does not belong to a word"() {
        def game = new Game(0, "Lemons", [:], 3)
        char letter = 'w'

        when:
        def newGame = game.tryLetter(letter)

        then:
        newGame.isFinished() == false
        newGame.livesLeft == 2
        newGame.uncoveredByPostion.size() == game.uncoveredByPostion.size()
    }

    def "trying a letter that does belong to a word"() {
        def game = new Game(0, "Lemons", [:], 3)
        char letter = 'l'

        when:
        def newGame = game.tryLetter(letter)

        then:
        newGame.isFinished() == false
        newGame.livesLeft == game.livesLeft
        newGame.uncoveredByPostion.containsKey("l") == true
    }

    def "trying a letter that does not belong to a word with one life left"() {
        def game = new Game(0, "Lemons", [:], 1)
        char letter = 'w'

        when:
        def newGame = game.tryLetter(letter)

        then:
        newGame.isFinished() == true
        newGame.livesLeft == 0
        newGame.uncoveredByPostion.size() == game.uncoveredByPostion.size()
    }

    def "trying a letter the last missing letter"() {
        def game = new Game(0,
                            "Lemons",
                            ["e":[2],
                             "m":[3],
                             "o":[4],
                             "n":[5],
                             "s":[6]],
                            3)
        char letter = 'l'

        when:
        def newGame = game.tryLetter(letter)

        then:
        newGame.isFinished() == true
        newGame.livesLeft == game.livesLeft
        newGame.uncoveredByPostion.size() >= game.uncoveredByPostion.size()
    }
}
