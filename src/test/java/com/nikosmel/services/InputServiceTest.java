package com.nikosmel.services;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class InputServiceTest {

    @Test
    public void getNumberShouldBePositiveUpTo10(){
        int maxNumber = 10;
        // -1 negative
        // 10000 is bigger than maxNumber
        // a is not a number
        // 2.3 in not an integer
        // 10 is a valid number
        // 5 function has accepted the previous in
        InputService.in = new Scanner("-1 10000 a 2.3 10 5");
        int number = InputService.getNumber("","",maxNumber);
        assertEquals(10,number);
    }

    @Test
    public void getOptionShouldBeBetween_1_and_3(){
        InputService.in = new Scanner("-1 10000 a 2.3 10 3");
        int number = InputService.getOption();
        assertEquals(3,number);
    }

}
