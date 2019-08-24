package com.nikosmel;

import com.nikosmel.services.AtmService;

import java.util.Locale;

/**
 * Atm Simulator
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Git World!" );
        AtmService.runAtmSimulator();
    }
}
