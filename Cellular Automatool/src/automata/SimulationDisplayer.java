package automata;

import util.MiscUtil;
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
	
	Color[] cols = new Color[simulator.automaton.getNumberOfStates()];
	for(int i = 0; i < cols.length; i++) {
	    cols[i] = MiscUtil.colorFromState(i, cols.length);
	}
	
	
	for (int i = 0; i < simulator.gridHeight; i++) {
	    for (int j = 0; j < simulator.gridWidth; j++) {

		g.setColor(cols[simulator.grid[i][j]]);
		g.fillRect((int) (i * dx), (int) (j * dy), (int) dx, (int) dy);
	    }
	}
    }
}
