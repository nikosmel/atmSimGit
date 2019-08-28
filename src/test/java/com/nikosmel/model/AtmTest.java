package com.nikosmel.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class AtmTest {

    @Test
    public void initAtmShouldInitializeTheAtmOnce(){
        Atm atm = Atm.initializeAtm(new int[]{10,10});
        Atm atm2 = Atm.initializeAtm(new int[]{20,20});
        assertArrayEquals(new int[]{10,10},atm2.getAmountOfNotes());
    }
}
