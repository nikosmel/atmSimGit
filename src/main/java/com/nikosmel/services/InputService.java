package com.nikosmel.services;

import com.nikosmel.resources.Messages;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputService {

    static Scanner in ;

    /**
     * @param s message for input
     * @param s2 message for wrong input
     * @param max_number
     * @return
     */
    static int getNumber(String s, String s2, int max_number) {
        if(in == null) {
            in = new Scanner(System.in);
        }
        int inputInt;
        do {  // Loop until we have correct input
            System.out.print(s);
            try {
                inputInt = in.nextInt(); // Blocks for user input
                if (inputInt >= 0 && inputInt <= max_number)  {
                    break;    // Got valid input, stop looping
                }else {
                    System.out.println(s2);
                    continue; // restart loop, wrong number
                }
            } catch (final InputMismatchException e) {
                System.out.println(Messages.INVALID_INPUT);
                in.next();    // discard non-int input
                continue;     // restart loop, didn't get an integer input
            }
        } while (true);
        return inputInt;
    }

    /**
     * @return int , the number of the desired option.
     */
    static int getOption(){
        return getNumber(Messages.GET_OPTIONS,Messages.ERROR_OPTION,3);
    }
}
