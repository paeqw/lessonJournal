package com.paeqw.utils;

public class InputValidator {
    public static String validateString(String input) {
        if (input.length() < 2) throw new IllegalArgumentException("this word is too short");
        else if (input.charAt(0) == ' ') throw new IllegalArgumentException("first letter should not be a space");
        else return input;
    }
}
