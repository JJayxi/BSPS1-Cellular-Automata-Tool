package automata;

import java.awt.Color;
import java.awt.Graphics2D;

public class SimulationDisplayer {

    private Simulator simulator;

    private float xPosition, yPosition, zoom;

    public SimulationDisplayer(Simulator simulator) {
	this.simulator = simulator;
    }

    public void setSimulator(Simulator simulator) {
	this.simulator = simulator;
    }

    public void draw(Graphics2D g, int width, int height) {
	float dx = height / simulator.gridHeight;
	float dy = width / simulator.gridWidth;

	for (int i = 0; i < simulator.gridHeight; i++) {
	    for (int j = 0; j < simulator.gridWidth; j++) {
		if (simulator.grid[i][j] == 1) {
		    g.setColor(Color.black);
		} else {
		    g.setColor(Color.white);
		}
		g.fillRect((int) (i * dx), (int) (j * dy), (int) dx, (int) dy);
	    }
	}
    }
}
