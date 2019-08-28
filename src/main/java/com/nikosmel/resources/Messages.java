package com.nikosmel.resources;

import com.nikosmel.model.Atm;

public interface Messages {

    String INVALID_INPUT = "You have entered an invalid input. Try again.";
    String INSERT_AVAILABLE_20_NOTES = "Please insert the number of the available 20 notes : ";
    String INSERT_AVAILABLE_50_NOTES = "Please insert the number of the available 50 notes : ";
    String INPUT_NOT_BETWEEN_0_MAX = "You have not entered a number between 0 and "+ Atm.getMax_numberOfNotes() +". Try again.";
    String INPUT_NOT_BETWEEN_0_MAXDISPENSE = "You have not entered a number between 0 and "+ Atm.getMax_dispense() +". Try again.";
    String SELECT_OPTION = "Select option:";
    String ATM_SIMULATOR = "-------------  ATM SIMULATOR -------- \n";
    String WITHDRAW_OPTION = " 1. Cash withdrawal";
    String AMOUNT_OPTION = " 2. View available notes";
    String EXIT_OPTION = " 3. Exit";
    String GET_OPTIONS = Messages.SELECT_OPTION + "\n" + Messages.WITHDRAW_OPTION + "\n" +
            Messages.AMOUNT_OPTION + "\n" + Messages.EXIT_OPTION + "\n";
    String ERROR_OPTION = "You have not entered a number between 1 and 3 . Try again.";
    String ENTER_THE_AMOUNT = "Please enter the amount you want to withdraw : ";
    String ERROR_ON_REDUCE_AMOUNT = "Error in execution withdraw process.Please try again.";
    String NO_COMBINATION = "There isn't combination for this amount of money!";
}
