package com.nikosmel.services;

import com.nikosmel.model.Atm;
import com.nikosmel.model.NoteEnum;
import com.nikosmel.resources.Messages;

import java.util.*;

public class AtmService {

    /**
     * Main function ,loop until user exit.
     */
    public static void runAtmSimulator() {
        Atm atm = initAtm();
        System.out.println(Messages.ATM_SIMULATOR);
        do {  // Loop until we have correct input
            try {
                processOption(atm, InputService.getOption());
            } catch (final InputMismatchException e) {
                System.out.println(Messages.INVALID_INPUT);
                continue;     // restart loop, didn't get an integer input
            }
        } while (true);
    }

    /**
     * Initialize Atm with the desired available notes.
     * @return
     */
    static Atm initAtm() {
        return Atm.initializeAtm(new int[]{
                InputService.getNumber(
                        Messages.INSERT_AVAILABLE_20_NOTES,
                        Messages.INPUT_NOT_BETWEEN_0_MAX,
                        Atm.getMax_numberOfNotes()),
                InputService.getNumber(
                        Messages.INSERT_AVAILABLE_50_NOTES,
                        Messages.INPUT_NOT_BETWEEN_0_MAX,
                        Atm.getMax_numberOfNotes())
        });
    }

    /**
     * reduceNotes use tempAtmAmount to check if the combination may cause invalid changes.
     * @param combination
     * @param atm
     * @return false if the process was invalid and true for valid changes.
     */
    static boolean reduceNotes(int[] combination,Atm atm){
        int[] tempAtmAmount = atm.getAmountOfNotes().clone();
        for (NoteEnum note : NoteEnum.values()) {
            if(tempAtmAmount[note.getKey()] - combination[note.getKey()] < 0){
                return false;
            }
            tempAtmAmount[note.getKey()] = tempAtmAmount[note.getKey()] - combination[note.getKey()];
        }
        atm.setAmountOfNotes(tempAtmAmount.clone());
        return true;
    }

    /**
     * Process the selected option
     * 1. withdraw
     * 2. view amount of notes
     * 3. exit
     * @param atm
     * @param actionInput
     */
    static void processOption(Atm atm, int actionInput){
        switch (actionInput){
            case 1:
                WithdrawService.cashWithdrawalProcess(atm);
                break;
            case 2:
                atm.printTheAmountOfTheNotes();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }


}
