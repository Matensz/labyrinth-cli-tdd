package com.vw.bench.epam.clitdddemo;

import com.vw.bench.epam.clitdddemo.model.Direction;
import com.vw.bench.epam.clitdddemo.model.Player;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Optional;

public class GoProcessorTest {

    @Mock
    private MapHandler mapHandler;

    private GoProcessor goProcessor;

    @BeforeMethod
    public void setUp() {
        goProcessor = new GoProcessor();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldMovePlayerToNextPosition() {
        Direction direction = Direction.NORTH;
        Player player = new Player("Player", 1, 1);
        goProcessor.setPlayer(player);
        goProcessor.setMapHandler(mapHandler);

        Mockito.when(mapHandler.getDirectionsForNextPosition(direction, player.getPosition().getX(),player.getPosition().getY()))
                .thenReturn(Arrays.asList(Direction.EAST, Direction.WEST));

        Optional<String> processedResult = goProcessor.process("north");

        Assert.assertEquals(processedResult, Optional.of("You can choose your next move from: EAST, WEST"));
    }

    @Test
    public void shouldSendDirectionsAfterWrongDirection() {
        Player player = new Player("Player", 1, 1);
        goProcessor.setPlayer(player);
        goProcessor.setMapHandler(mapHandler);

        Mockito.when(mapHandler.getDirectionsForCurrentPosition(player.getPosition().getX(), player.getPosition().getY())).thenReturn(Arrays.asList(Direction.SOUTH, Direction.NORTH));

        Optional<String> processedResult = goProcessor.process("west");

        Assert.assertEquals(processedResult, Optional.of("Wrong direction :( You can choose your next move from: SOUTH, NORTH"));
    }

}
