package io.github.lpedrosa.domain;

import static org.junit.Assert.*
import spock.lang.*

class GameCompletedTests extends Specification {

    def "isFinished behaviour when no more lives"() {
        def game = new Game(0, "Lemons", ["l": [1], "e": [2]], 0)

        when:
        def res = game.isFinished()

        then:
        res == true
    }

    def "isFinished behaviour when all the letters are guessed"() {
        def game = new Game(0,
                            "Lemons",
                            ["l":[1],
                             "e":[2],
                             "m":[3],
                             "o":[4],
                             "n":[5],
                             "s":[6]],
                            3)

        when:
        def res = game.isFinished()

        then:
        res == true
    }

    def "isFinished behaviour when game is unfinished"() {
        def game1 = new Game(0, "Lemons", [:], 3)
        def game2 = new Game(0, "Lemons", ["l": [1], "e": [2]], 3)

        when:
        def res1 = game1.isFinished()
        def res2 = game2.isFinished()

        then:
        res1 == false
        res2 == false
    }
}
