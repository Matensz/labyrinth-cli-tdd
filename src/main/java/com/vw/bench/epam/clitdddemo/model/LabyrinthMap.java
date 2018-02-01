package com.vw.bench.epam.clitdddemo.model;

public class LabyrinthMap {

    private LabyrinthMapUnit[][] labyrinth;

    public LabyrinthMap() {
    }

    public LabyrinthMap(int x, int y) {
        labyrinth = new LabyrinthMapUnit[x][y];
    }

    public LabyrinthMapUnit[][] getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(int x, int y) {
        this.labyrinth = new LabyrinthMapUnit[x][y];
    }

    public int getLabyrinthHeight() {
        if (labyrinth.length > 0) {
            return labyrinth[0].length;
        } else {
            return 0;
        }
    }

    public int getLabyrinthWidth(){
        return labyrinth.length;
    }

}
