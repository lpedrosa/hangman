package io.github.lpedrosa.domain;

import static org.junit.Assert.*

import org.junit.Test

class GameCompletedTests {

	@Test
	void isFinishedShouldReturnTrueWhenNoMoreLives() {
		def noMoreLives = new Game(0, "Lemons", ["l": [1], "e": [2]], 0);

		assertTrue(noMoreLives.isFinished());
	}

	@Test
	void isFinishedShouldReturnTrueWhenAllLettersGuessed() {
		def allLettersGuessed = new Game(0,
									"Lemons",
									["l":[1],
									 "e":[2],
									 "m":[3],
									 "o":[4],
									 "n":[5],
									 "s":[6]],
									3);

		assertTrue(allLettersGuessed.isFinished());
	}

	@Test
	void isFinishedShouldReturnFalseWhenUnfinished() {
		def unfinishedGame = new Game(0, "Lemons", [:], 3);
		assertFalse(unfinishedGame.isFinished());

		unfinishedGame = new Game(0, "Lemons", ["l": [1], "e": [2]], 3);
		assertFalse(unfinishedGame.isFinished());
	}
}
