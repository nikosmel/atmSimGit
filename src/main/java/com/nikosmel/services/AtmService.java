package com.nikosmel.services;

import com.nikosmel.classes.Atm;

import java.util.*;

public class AtmService {

    public static void runAtmSimulator(){
        Atm atm = initAtm();
        //cashDispensingProcess(atm);
        do {  // Loop until we have correct input
            try {
                getAction();
                doAction(atm);
            } catch (final InputMismatchException e) {
                System.out.println("You have entered an invalid input. Try again.");
                continue;     // restart loop, didn't get an integer input
            }
        } while (true);
    }

    private static Atm initAtm() {
        return Atm.initializeAtm(
                InputService.getNumber(
                        "Please insert the number of the available 20 notes : " ,
                        "You have not entered a number between 0 and "+ Atm.getMax_numberOf_20_notes() +". Try again.",
                        Atm.getMax_numberOf_20_notes()),
                InputService.getNumber(
                        "Please insert the number of the available 50 notes : ",
                        "You have not entered a number between 0 and "+ Atm.getMax_numberOf_50_notes() +". Try again.",
                        Atm.getMax_numberOf_50_notes()));
    }

    private static int getAction(){
        return InputService.getNumber(
                "If you like tou dispense money please press number : 1 \n" +
                        "If you like tou see  the amount of notes please press number : 2 \n" +
                        "If you like tou exit please press number : 3 \n",
                "You have not entered a number between 0 and 3 . Try again.",
                3);
    }

    private static void doAction(Atm atm){
        int input = InputService.getNumber(
                "If you like tou dispense money please press number : 1 \n" +
                        "If you like tou see  the amount of notes please press number : 2 \n" +
                        "If you like tou exit please press number : 3 \n",
                "You have not entered a number between 0 and 3 . Try again.",
                3);
        switch (input){
            case 1:
                cashDispensingProcess(atm);
                break;
            case 2:
                Map<Integer, Integer> map = getTheCombination(input,atm);
                System.out.println("you can draw "+ map.get(20) + " of 20 notes .");
                System.out.println("you can draw "+ map.get(50) + " of 50 notes .");
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    private static void cashDispensingProcess(Atm atm){
        int input = InputService.getNumber(
                "Please enter the amount you want to withdraw : ",
                "You have not entered a number between 0 and "+ Atm.getMax_numberOf_50_notes() +". Try again.",
                Atm.getMax_dispense());
        Map<Integer, Integer> map = getTheCombination(input,atm);
        if(!map.isEmpty()){
            System.out.println("you can draw "+ map.get(20) + " of 20 notes .");
            System.out.println("you can draw "+ map.get(50) + " of 50 notes .");
        }else{
            System.out.println("Process can't be satisfied");
        }

    }

    static Map<Integer, Integer> getTheCombination(int userInput, Atm atm){
        Map<Integer, Integer> map = new HashMap<>();
        int atmMaxCashValue = atm.getNumberOf_20_notes() * 20 + atm.getNumberOf_50_notes() * 50 ;
        if(atmMaxCashValue < userInput){
            System.out.println("Atm doesn't have so many notes!");
            return map;
        }
        map.put(20,3);
        map.put(50,5);
        return map;
    }


}
