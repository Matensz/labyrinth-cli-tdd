package com.vw.bench.epam.clitdddemo;

import com.vw.bench.epam.clitdddemo.model.Direction;
import com.vw.bench.epam.clitdddemo.model.LabyrinthMap;
import com.vw.bench.epam.clitdddemo.model.LabyrinthMapUnit;
import com.vw.bench.epam.clitdddemo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@SpringBootApplication
public class CliTddDemoApplication implements CommandLineRunner {

    private LineByLineParser lineByLineParser;

    private CommandLineProcessor commandLineProcessor;

    private Player player;

    private LabyrinthMap labyrinthMap;

    private GoProcessor goProcessor;

    private MapHandler mapHandler;

    @Autowired
    public void setLineByLineParser(LineByLineParser lineByLineParser) {
        this.lineByLineParser = lineByLineParser;
    }

    @Autowired
    public void setCommandLineProcessor(CommandLineProcessor commandLineProcessor) {
        this.commandLineProcessor = commandLineProcessor;
    }

    @Autowired
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Autowired
    public void setLabyrinthMap(LabyrinthMap labyrinthMap) {
        this.labyrinthMap = labyrinthMap;
    }

    @Autowired
    public void setGoProcessor(GoProcessor goProcessor) {
        this.goProcessor = goProcessor;
    }

    @Autowired
    public void setMapHandler(MapHandler mapHandler) {
        this.mapHandler = mapHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(CliTddDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Choose a name for your player!");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        player.setName(name);
        player.setPosition(2, 0);
        System.out.println("Choose a difficulty (easy, medi, hard)!");
        String difficulty = scanner.nextLine();
        //TODO mapbetöltés
        switch (difficulty) {
            case "easy":
                System.out.println("Easy map loaded!");
                labyrinthMap = new LabyrinthMap(3, 3);
                labyrinthMap.getLabyrinth()[0][0] = new LabyrinthMapUnit(Direction.WEST, Direction.NORTH);
                labyrinthMap.getLabyrinth()[0][1] = new LabyrinthMapUnit(Direction.NORTH);
                labyrinthMap.getLabyrinth()[0][2] = new LabyrinthMapUnit(Direction.NORTH, Direction.EAST);
                labyrinthMap.getLabyrinth()[1][0] = new LabyrinthMapUnit(Direction.WEST, Direction.SOUTH, Direction.EAST);
                labyrinthMap.getLabyrinth()[1][1] = new LabyrinthMapUnit(Direction.WEST, Direction.EAST);
                labyrinthMap.getLabyrinth()[1][2] = new LabyrinthMapUnit(Direction.EAST, Direction.WEST);
                labyrinthMap.getLabyrinth()[2][0] = new LabyrinthMapUnit(Direction.NORTH, Direction.SOUTH);
                labyrinthMap.getLabyrinth()[2][1] = new LabyrinthMapUnit(Direction.EAST, Direction.SOUTH);
                labyrinthMap.getLabyrinth()[2][2] = new LabyrinthMapUnit(Direction.WEST, Direction.SOUTH);
                mapHandler.setLabyrinthMap(labyrinthMap);
                break;
            case "medi":
                System.out.println("Medium map loaded!");
                break;
            case "hard":
                System.out.println("Hard map loaded!");
                break;
            default:
                System.out.println("Bad input moron!");
                System.exit(-1);
                break;
        }

        String line;
        while (!(line = scanner.nextLine()).equals("exit")) {
            lineByLineParser.start(System.out, new ByteArrayInputStream(line.getBytes()));
        }
    }

}
