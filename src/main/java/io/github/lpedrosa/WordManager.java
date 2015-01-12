package io.github.lpedrosa;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class WordManager {

    private final static List<String> WORDS = Arrays.asList("lemon",
                                                            "otorhinolaryngology",
                                                            "elephant",
                                                            "strawberry",
                                                            "prometheus",
                                                            "science",
                                                            "functional");

    public String fetchRandomWord() {
        final int randomInt = ThreadLocalRandom.current().nextInt(WORDS.size());
        return WORDS.get(randomInt);
    }

}
