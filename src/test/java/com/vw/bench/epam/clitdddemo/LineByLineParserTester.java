package com.vw.bench.epam.clitdddemo;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;

public class LineByLineParserTester {

    private CommandLineProcessor commandLineProcessor;

    private LineByLineParser lineByLineParser;

    private InputStream inputStream;

    private PrintStream printStream;

    @BeforeMethod
    public void setUp(){
        lineByLineParser = new LineByLineParser();
        commandLineProcessor = Mockito.mock(CommandLineProcessor.class);
        inputStream = new ByteArrayInputStream("go east\ngo west".getBytes());
        printStream = Mockito.mock(PrintStream.class);
    }

    @Test
    public void shouldReturnDirection(){
        String processedResult1 = "west, north";
        String processedResult2 = "south";
        lineByLineParser.setCommandLineProcessor(commandLineProcessor);
        Mockito.when(commandLineProcessor.process("go east")).thenReturn(Optional.of(processedResult1));
        Mockito.when(commandLineProcessor.process("go west")).thenReturn(Optional.of(processedResult2));

        lineByLineParser.start(printStream, inputStream);

        Mockito.verify(printStream).println(processedResult1);
        Mockito.verify(printStream).println(processedResult2);
    }



}
