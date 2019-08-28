package com.nikosmel.services;

import com.nikosmel.model.Atm;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class AtmServiceTest {

    @Test
    public void initAtmShouldBeNotNull(){
        InputService.in = new Scanner("10 5");
        Atm atm = AtmService.initAtm();
        assertNotNull(atm);
    }

}