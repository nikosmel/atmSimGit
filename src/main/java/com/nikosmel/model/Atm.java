package com.nikosmel.model;

public class Atm {

    private static Atm instance = null;
    private static final int max_numberOfNotes = 10000;
    private static final int max_dispense = 100000;
    private static int[] availableNotes = {NoteEnum.note20.getValue(), NoteEnum.note50.getValue()};
    private int[] amountOfNotes;

    private Atm(int[] amountOfNotes) {
        this.amountOfNotes = amountOfNotes;
    }

    public static Atm initializeAtm(int[] amountOfNotes) {
        if (instance == null) {
            instance = new Atm(amountOfNotes);
        }
        return instance;
    }

    public void setAmountOfNotes(int[] amountOfNotes){
        this.amountOfNotes = amountOfNotes;
    }

    private int getNumberOf_20_notes() {
        return this.amountOfNotes[NoteEnum.note20.getKey()];
    }

    private int getNumberOf_50_notes() {
        return this.amountOfNotes[NoteEnum.note50.getKey()];
    }

    public static int getMax_numberOfNotes() {
        return max_numberOfNotes;
    }

    public static int getMax_dispense() {
        return max_dispense;
    }

    public void printTheAmountOfTheNotes() {
        System.out.println("The ATM contains: \n" +
                getNumberOf_20_notes() + " of 20$ notes \n" +
                getNumberOf_50_notes() + " of 50$ notes");
    }

    public static int[] getAvailableNotes() {
        return availableNotes;
    }

    public int[] getAmountOfNotes() {
        return amountOfNotes;
    }
}
