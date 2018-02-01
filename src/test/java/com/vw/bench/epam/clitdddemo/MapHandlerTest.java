package com.vw.bench.epam.clitdddemo;

import com.vw.bench.epam.clitdddemo.model.Direction;
import com.vw.bench.epam.clitdddemo.model.LabyrinthMap;
import com.vw.bench.epam.clitdddemo.model.LabyrinthMapUnit;
import com.vw.bench.epam.clitdddemo.model.Player;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MapHandlerTest {

    private LabyrinthMap labyrinthMap;

    private MapHandler mapHandler;

    @BeforeTest
    public void setUp() {
        mapHandler = new MapHandler();
    }

    @Test
    public void shouldReturnDirectionsBasedOnNextPosition() {
        Direction direction = Direction.SOUTH;
        Player player = new Player("banános joe", 0, 0);
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

        List<Direction> directionsForNextPosition
                = mapHandler.getDirectionsForNextPosition(direction, player.getPosition().getX(), player.getPosition().getY());
        Assert.assertEquals(directionsForNextPosition, Arrays.asList(Direction.NORTH));


    }

    @Test
    public void shouldReturnDirectionsBasedOnCurrentPosition() {
        Player player = new Player("banános joe", 0, 0);
        labyrinthMap = new LabyrinthMap(3, 3);
        labyrinthMap.getLabyrinth()[0][0] = new LabyrinthMapUnit(Direction.EAST, Direction.SOUTH);
        mapHandler.setLabyrinthMap(labyrinthMap);

        Assert.assertEquals(
                mapHandler.getDirectionsForCurrentPosition(
                        player.getPosition().getX(),
                        player.getPosition().getY()),
                Arrays.asList(Direction.NORTH, Direction.WEST));
    }

}
