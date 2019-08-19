package com.nikosmel;

import static org.junit.Assert.assertTrue;

import com.nikosmel.services.InputService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private void provideInput(final int in) {
        InputStream testIn = new InputStream() {
            @Override
            public int read() throws IOException {
                return in;
            }
        };
        System.setIn(testIn);
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldBeUpToZero()
    {
        provideInput(4);
       // assertTrue(InputService.getNumber("",300) > 0);
    }
}
