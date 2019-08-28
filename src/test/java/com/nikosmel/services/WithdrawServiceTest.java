package com.nikosmel.services;

import com.nikosmel.model.Atm;
import org.junit.Test;

import static org.junit.Assert.*;

public class WithdrawServiceTest {

    @Test
    public void findCombinationTest(){
        int noteIndex = Atm.getAvailableNotes().length;

        int[] combination = WithdrawService.findCombination(
                new int[]{10,10},100,noteIndex-1, new int[]{0,0});
        assertNotNull("Should contains 20$ notes only or 50$ notes only.",combination);

        combination = WithdrawService.findCombination(
                new int[]{10,10},580,noteIndex-1, new int[]{0,0});
        assertNotNull("Should contains 20$ notes and 50$ notes.",combination);

        combination = WithdrawService.findCombination(
                new int[]{10,10},700,noteIndex-1, new int[]{0,0});
        assertNotNull("Should contains all the notes.",combination);

        combination = WithdrawService.findCombination(
                new int[]{2,10},110,noteIndex-1, new int[]{0,0});
        assertNull("Should be null .Requires 3 20$ notes." ,combination);

        combination = WithdrawService.findCombination(
                new int[]{10,10},1000,noteIndex-1, new int[]{0,0});
        assertNull("Should be null .Requires more notes.",combination);

        combination = WithdrawService.findCombination(
                new int[]{10,10},30,noteIndex-1, new int[]{0,0});
        assertNull("Should be null .There isn't combination.",combination);

    }
}
