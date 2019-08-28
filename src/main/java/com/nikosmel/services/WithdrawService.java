package com.nikosmel.services;

import com.nikosmel.model.Atm;
import com.nikosmel.model.NoteEnum;
import com.nikosmel.resources.Messages;

import java.util.Objects;

class WithdrawService {

    /**
     * User enter a number and the function check for an combination of notes .
     * If combination is not null then atm reduce the available notes and the
     * function prints the combination . Otherwise the function prints that
     * there isn't combination.
     * @param atm
     */
    static void cashWithdrawalProcess(Atm atm){
        int input = InputService.getNumber(
                Messages.ENTER_THE_AMOUNT,Messages.INPUT_NOT_BETWEEN_0_MAXDISPENSE,Atm.getMax_dispense());
        int[] combination = findCombination(atm.getAmountOfNotes().clone(),input,
                atm.getAmountOfNotes().length-1, new int[]{0,0});
        if(Objects.nonNull(combination)) {
            if(!AtmService.reduceNotes(combination,atm)){
                System.out.println(Messages.ERROR_ON_REDUCE_AMOUNT);
            }
            printTheCombination(combination);
        }else{
            System.out.println(Messages.NO_COMBINATION);
        }
    }

    /**
     * findCombination uses recursive to find the combination of notes
     * regardless the available notes.
     *
     * @param atmAmount amount of available notes
     * @param price the amount that user wants to withdraw
     * @param noteIndex index between notes
     * @param combination the result
     * @return
     */
    static int[] findCombination(int[] atmAmount, int price, int noteIndex, int[] combination) {
            if(noteIndex < 0){return null;}
            for (int i = 0; i <= atmAmount[noteIndex]; i++) {
                combination[noteIndex] = i;
                int sum = countSum(combination);
                if(sum == price){
                    return combination;
                }
                int[] tempCombination = findCombination(atmAmount, price, noteIndex - 1, combination.clone());
                if(tempCombination != null){
                    return tempCombination;
                }
            }
        return null;
    }

    /**
     * function that helps findCombination if the combination satisfies the desired withdraw.
     * @param combination
     * @return
     */
    private static int countSum(int[] combination){
        int sum = 0 ;
        for(int i=0 ; i < combination.length ; i++){
            sum = sum + combination[i] * Atm.getAvailableNotes()[i];
        }
        return sum;
    }

    /**
     * Print the combination of notes.
     * @param combination
     */
    private static void printTheCombination(int[] combination){
        for (NoteEnum note : NoteEnum.values()){
            System.out.println("You can draw "+ combination[note.getKey()] + " of " + note.getValue() +"$ notes.\n");
        }
    }
}
