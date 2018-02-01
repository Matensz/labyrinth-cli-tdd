package com.vw.bench.epam.clitdddemo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommandLineProcessor {

    public static final String GO = "GO";

    private GoProcessor goProcessor;

    @Autowired
    public void setGoProcessor(GoProcessor goProcessor) {
        this.goProcessor = goProcessor;
    }

    public Optional<String> process(String line) {
        String[] inputArray = line.split(" ");
        if (inputArray.length < 2) {
            return Optional.of("Wrong format! Use [command] [parameter]!");
        }
        switch (inputArray[0].toUpperCase()) {
            case GO:
                return goProcessor.process(inputArray[1].toLowerCase());
            default:
                return Optional.of("Wrong command used!");
        }
    }
}
