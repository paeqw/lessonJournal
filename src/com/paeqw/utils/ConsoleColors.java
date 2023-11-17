package com.paeqw.utils;

public class ConsoleColors {
    public static String paint(String str, int color) {
        String colorCode = "";
        String reset = "\u001B[0m";
        switch (color) {
            case 1 -> {
                // red
                colorCode = "\u001B[31m";
                return (colorCode + str + reset);
            }
            case 2 -> {
                // green
                colorCode = "\u001B[32m";
                return (colorCode + str + reset);
            }
            case 3 -> {
                colorCode = "\u001B[33m";
                return (colorCode + str + reset);
            }
            default -> {
                return str;
            }
        }
    }
}
