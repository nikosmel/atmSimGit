package com.nikosmel.classes;

public class Atm {

    private static Atm instance = null;
    private int numberOf_50_notes;
    private int numberOf_20_notes;
    private static final int max_numberOf_50_notes = 10000;
    private static final int max_numberOf_20_notes = 10000;
    private static final int max_dispense = 100000;


    private Atm(int numberOf_20_notes,int numberOf_50_notes){
        this.numberOf_20_notes = numberOf_20_notes;
        this.numberOf_50_notes = numberOf_50_notes;
    }

    public static Atm initializeAtm(int numberOf_20_notes,int numberOf_50_notes) {
        if(instance == null) {
            instance = new Atm(numberOf_20_notes,numberOf_50_notes);
        }
        return instance;
    }

    public int getNumberOf_50_notes() {
        return numberOf_50_notes;
    }

    public void reduceNumberOf_50_notes(int numberOfRemoved_50_notes) {
        this.numberOf_50_notes = this.numberOf_50_notes - numberOfRemoved_50_notes;
    }

    public int getNumberOf_20_notes() {
        return numberOf_20_notes;
    }

    public static int getMax_numberOf_50_notes() {
        return max_numberOf_50_notes;
    }

    public static int getMax_numberOf_20_notes() {
        return max_numberOf_20_notes;
    }

    public static int getMax_dispense() {
        return max_dispense;
    }

    public void reduceNumberOf_20_notes(int numberOfRemoved_20_notes) {
        this.numberOf_20_notes = this.numberOf_20_notes - numberOfRemoved_20_notes;
    }
}
