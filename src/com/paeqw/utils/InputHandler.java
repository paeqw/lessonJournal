package com.paeqw.utils;

import java.util.Scanner;

public class InputHandler {
    public int getInt(String prompt) throws NumberFormatException {
        try{
            System.out.print(prompt + ": ");
            String input = new Scanner(System.in).nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("input given is not a number");
        }
    }

    public int getInt() throws NumberFormatException {
        try{
            String input = new Scanner(System.in).nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("input given is not a number");
        }
    }
    public String getString(String prompt) throws IllegalArgumentException{
        System.out.print(prompt + ": ");
        String input = new Scanner(System.in).nextLine();
        return InputValidator.validateString(input) ;
    }

    public String getString() throws IllegalArgumentException{
        String input = new Scanner(System.in).nextLine();
        return InputValidator.validateString(input) ;
    }

}
