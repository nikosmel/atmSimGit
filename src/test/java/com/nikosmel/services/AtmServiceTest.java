package com.nikosmel.services;

import com.nikosmel.classes.Atm;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmServiceTest {

    @Test
    public void getTheCombinationShouldBeNotNull(){
        Atm atm = Atm.initializeAtm(100,100);
        assertNotNull(AtmService.getTheCombination(300,atm));
    }

}