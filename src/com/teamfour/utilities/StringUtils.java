package com.teamfour.utilities;

public final class StringUtils {

    private StringUtils() {

    }

    public static String[] tokenize(String input) {
        String[] words = input.split(" ");
        return words;
    }

}
