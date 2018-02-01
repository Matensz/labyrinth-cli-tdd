package com.vw.bench.epam.clitdddemo;

import com.vw.bench.epam.clitdddemo.model.Direction;
import com.vw.bench.epam.clitdddemo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GoProcessor {

    private Player player;
    private MapHandler mapHandler;

    private static final String PROCESSED_GO_MESSAGE_OK = "You can choose your next move from: ";
    private static final String PROCESSED_GO_MESSAGE_ERR = "Wrong direction :( " + PROCESSED_GO_MESSAGE_OK;

    private static final Map<String, Direction> directionMapper = createMap();

    private static Map<String, Direction> createMap() {
        Map<String, Direction> map = new HashMap<>();
        map.put("NORTH", Direction.NORTH);
        map.put("SOUTH", Direction.SOUTH);
        map.put("EAST", Direction.EAST);
        map.put("WEST", Direction.WEST);
        return map;
    }

    @Autowired
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Autowired
    public void setMapHandler(MapHandler mapHandler) {
        this.mapHandler = mapHandler;
    }

    public Optional<String> process(String direction) {
        List<Direction> directions;
        Direction dir = directionMapper.get(direction.toUpperCase());
        if (dir != null) {
            directions = mapHandler.getDirectionsForNextPosition(dir, player.getPosition().getX(), player.getPosition().getY());
            if (!directions.isEmpty()) {
                player.setPosition(player.getPosition().getX() + dir.getX(), player.getPosition().getY() + dir.getY());
                System.out.println("Debug: X-> " + player.getPosition().getX() + " Y ->" + player.getPosition().getY());
                return convertDirectionsToString(directions, PROCESSED_GO_MESSAGE_OK);
            }
        }
        directions = mapHandler.getDirectionsForCurrentPosition(player.getPosition().getX(), player.getPosition().getY());
        return convertDirectionsToString(directions, PROCESSED_GO_MESSAGE_ERR);
    }

    private Optional<String> convertDirectionsToString(List<Direction> directions, String message) {
        return Optional.of(directions.stream()
                .map(Direction::name)
                .collect(Collectors.joining(", ", message, "")));
    }
}
