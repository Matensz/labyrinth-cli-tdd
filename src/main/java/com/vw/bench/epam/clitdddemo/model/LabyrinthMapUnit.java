package com.vw.bench.epam.clitdddemo.model;

import java.util.*;
import java.util.stream.Collectors;

public class LabyrinthMapUnit {

    private final List<Direction> walls;

    public LabyrinthMapUnit(Direction... wall) {
        this.walls = Arrays.asList(wall);
    }

    public List<Direction> getWalls() {
        return walls;
    }

    public List<Direction> getPassages(){
        List<Direction> directions = Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST);
        return directions.stream()
                .filter(direction -> !walls.contains(direction))
                .sorted(Comparator.comparing(Enum::name))
                .collect(Collectors.toList());
    }
}
