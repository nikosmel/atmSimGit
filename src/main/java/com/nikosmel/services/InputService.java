package com.nikosmel.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputService {
    public static int getNumber(String s ,String s2 ,int max_number) {
        final Scanner in = new Scanner(System.in);
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
                System.out.println("You have entered an invalid input. Try again.");
                in.next();    // discard non-int input
                continue;     // restart loop, didn't get an integer input
            }
        } while (true);
        return inputInt;
    }
}
