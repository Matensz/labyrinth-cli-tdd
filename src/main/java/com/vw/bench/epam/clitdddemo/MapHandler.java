package com.vw.bench.epam.clitdddemo;

import com.vw.bench.epam.clitdddemo.model.Direction;
import com.vw.bench.epam.clitdddemo.model.LabyrinthMap;
import com.vw.bench.epam.clitdddemo.model.LabyrinthMapUnit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MapHandler {

    private LabyrinthMap labyrinthMap;
    private LabyrinthMapUnit labyrinthMapUnit;

    @Autowired
    public void setLabyrinthMap(LabyrinthMap labyrinthMap) {
        this.labyrinthMap = labyrinthMap;
    }

    @Autowired
    public void setLabyrinthMapUnit(LabyrinthMapUnit labyrinthMapUnit) {
        this.labyrinthMapUnit = labyrinthMapUnit;
    }

    public List<Direction> getDirectionsForNextPosition(Direction direction, int positionX, int positionY) {
        List<Direction> directionsForCurrentPosition = getDirectionsForCurrentPosition(positionX, positionY);
        if (directionsForCurrentPosition.contains(direction)) {
            int newX = positionX + direction.getX();
            int newY = positionY + direction.getY();
            return getDirectionsForCurrentPosition(newX, newY);
        }
        return new ArrayList<>();
    }


    public List<Direction> getDirectionsForCurrentPosition(int positionX, int positionY) {
        labyrinthMapUnit = labyrinthMap.getLabyrinth()[positionX][positionY];
        return labyrinthMapUnit.getPassages();
    }
}
