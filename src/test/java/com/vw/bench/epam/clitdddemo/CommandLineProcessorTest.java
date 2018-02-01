package com.vw.bench.epam.clitdddemo;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class CommandLineProcessorTest {

    private CommandLineProcessor commandLineProcessor;

    private GoProcessor goProcessor;

    @BeforeMethod
    public void setUp() {
        commandLineProcessor = new CommandLineProcessor();
        goProcessor = Mockito.mock(GoProcessor.class);
    }

    @Test
    public void shouldReturnDirection() {
        String resultDirections1 = "south, west";
        String resultDirections2 = "north, east";

        commandLineProcessor.setGoProcessor(goProcessor);
        Mockito.when(goProcessor.process("north")).thenReturn(Optional.of(resultDirections1));
        Mockito.when(goProcessor.process("west")).thenReturn(Optional.of(resultDirections2));

        Optional<String> goNorth = commandLineProcessor.process("go north");
        Optional<String> goWest = commandLineProcessor.process("go west");

        Assert.assertEquals(resultDirections1, goNorth.get());
        Assert.assertEquals(resultDirections2, goWest.get());
    }

}
