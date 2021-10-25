package automata;

import util.MiscUtil;
import java.awt.Color;
import java.awt.Graphics2D; 

public class SimulationDisplayer {
    
    /**
     * The simulator that will be displayed
     */
    private Simulator simulator;

    /**
     * 
     * @param simulator The simulator that will be displayed
     */
    public SimulationDisplayer(Simulator simulator) {
	this.simulator = simulator;
    }
    
    /**
     * 
     * @param simulator Set the simulator that will be displayed
     */
    public void setSimulator(Simulator simulator) {
	this.simulator = simulator;
    }
    
    /**
     * Displays the simulator on a JPanel. The color of the states of the cells
     * are generated with MiscUtil.colorFromState.
     * @param g The graphics2D object of the JPanel
     * @param width the width in pixels of the JPanel
     * @param height the height in pixels of the JPanel
     */
    public void draw(Graphics2D g, int width, int height) {
	float dx = (float)height / simulator.gridHeight;
	float dy = (float)width / simulator.gridWidth;
	
	Color[] cols = new Color[simulator.automaton.getNumberOfStates()];
	for(int i = 0; i < cols.length; i++)
	    cols[i] = MiscUtil.colorFromState(i, cols.length);
	
	
	for (int i = 0; i < simulator.gridHeight; i++) {
	    for (int j = 0; j < simulator.gridWidth; j++) {

		g.setColor(cols[simulator.grid[i][j]]);
		g.fillRect((int) (i * dx), (int) (j * dy), (int) dx + 1, (int) dy + 1);
	    }
	}
    }
}
