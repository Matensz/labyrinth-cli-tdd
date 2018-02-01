package com.vw.bench.epam.clitdddemo;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class LineByLineParser {

    private CommandLineProcessor commandLineProcessor;

    @Autowired
    public void setCommandLineProcessor(CommandLineProcessor commandLineProcessor) {
        this.commandLineProcessor = commandLineProcessor;
    }

    public void start(PrintStream printStream, InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Optional<String> opt = commandLineProcessor.process(line);
            opt.ifPresent(printStream::println);
        }
    }
}
