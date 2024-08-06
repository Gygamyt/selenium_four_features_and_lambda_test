package geightgeight.seleniumremember.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorOfRandomThings {
    private static final String[] WORDS = {
            "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog",
            "hello", "world", "java", "programming", "language", "random", "sentence",
            "example", "generate", "text", "simple", "method", "code", "sample", "words"
    };

    private static final Random RANDOM = new Random();

    public static String generateSentence(int wordCount) {
        if (wordCount <= 0) {
            throw new IllegalArgumentException("Word count must be greater than 0");
        }

        List<String> sentenceWords = new ArrayList<>();
        for (int i = 0; i < wordCount; i++) {
            String word = WORDS[RANDOM.nextInt(WORDS.length)];
            sentenceWords.add(word);
        }

        String sentence = String.join(" ", sentenceWords) + ".";

        return Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
    }
}
