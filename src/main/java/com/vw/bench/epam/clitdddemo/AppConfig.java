package com.vw.bench.epam.clitdddemo;

import com.vw.bench.epam.clitdddemo.model.LabyrinthMap;
import com.vw.bench.epam.clitdddemo.model.LabyrinthMapUnit;
import com.vw.bench.epam.clitdddemo.model.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public LineByLineParser lineByLineParser() {
        return new LineByLineParser();
    }

    @Bean
    public CommandLineProcessor commandLineProcessor() {
        return new CommandLineProcessor();
    }

    @Bean
    public GoProcessor goProcessor() {
        return new GoProcessor();
    }

    @Bean
    public Player player(){
        return new Player();
    }

    @Bean
    public MapHandler mapHandler() {
        return new MapHandler();
    }

    @Bean
    public LabyrinthMap labyrinthMap() {
        return new LabyrinthMap();
    }

    @Bean
    public LabyrinthMapUnit labyrinthMapUnit() {
        return new LabyrinthMapUnit();
    }

}
