package com.nikosmel.services;

import com.nikosmel.classes.Atm;

import java.util.*;

public class AtmService {

    public static void runAtmSimulator(){
        Atm atm = initAtm();
        cashDispensingProcess(atm);
    }

    private static Atm initAtm() {
        return Atm.initializeAtm(
                InputService.getNumber(
                        "Please insert the number of the available 20 notes : ",
                        "You have not entered a number between 0 and "+ Atm.getMax_numberOf_20_notes() +". Try again.",
                        Atm.getMax_numberOf_20_notes()),
                InputService.getNumber(
                        "Please insert the number of the available 50 notes : ",
                        "You have not entered a number between 0 and "+ Atm.getMax_numberOf_50_notes() +". Try again.",
                        Atm.getMax_numberOf_50_notes()));
    }

    private static void ui (Atm atm){
        int input = InputService.getNumber(
                "If you like tou dispense money please press number : 1 \n" +
                        "If you like tou see  the amount of notes please press number : 2 \n" +
                        "If you like tou exit please press number : 3 \n",
                "You have not entered a number between 0 and 3 . Try again.",
                3);
        switch (input){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private static void cashDispensingProcess(Atm atm){
        int input = InputService.getNumber(
                "Please enter the amount you want to withdraw : ",
                "You have not entered a number between 0 and "+ Atm.getMax_numberOf_50_notes() +". Try again.",
                Atm.getMax_dispense());
        Map map = getTheCombination(input,atm);
        if(!map.isEmpty()){
            System.out.println("you can draw "+ map.get(20) + " of 20 notes .");
            System.out.println("you can draw "+ map.get(50) + " of 50 notes .");
        }else{
            cashDispensingProcess(atm);
        }

    }

    private static Map getTheCombination(int userInput, Atm atm){
        Map map = new HashMap();
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
