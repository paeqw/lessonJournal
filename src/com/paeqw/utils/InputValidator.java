package com.paeqw.utils;

import com.paeqw.enums.DayOfWeek;

public class InputValidator {
    public static String validateString(String input) {
        if (input.length() < 2) throw new IllegalArgumentException("this word is too short");
        else if (input.charAt(0) == ' ') throw new IllegalArgumentException("first letter should not be a space");
        else return input;
    }

    public DayOfWeek getDayOfWeek() {
        InputHandler ih = new InputHandler();
        String value = ih.getString("Enter day of the week");
        String[] validValue = {"Monday","Tuesday", "Wednesday", "Thursday", "Friday"};
        for (var el:validValue) {
            if (el.equalsIgnoreCase(value)) return DayOfWeek.valueOf(value);
        }
        throw new IllegalArgumentException("this word is not a day of school week (Mon-Fri)");
    }
}
