package automata;

import java.awt.BasicStroke;
import util.MiscUtil;
import java.awt.Color;
import java.awt.Graphics2D; 
import java.awt.geom.Point2D;

public class SimulationDisplayer {
    
    /**
     * The simulator that will be displayed
     */
    private Simulator simulator;
    private float scale;
    private Point2D offset;

    /**
     * @param simulator The simulator that will be displayed
     */
    public SimulationDisplayer(Simulator simulator, int width, int height) {
	this.simulator = simulator;
	resetPosition(width);
    }
    
    public Simulator getSimulator() {
	return simulator;
    }
    
    public void resetPosition(int width) {
	offset = new Point2D.Double(0, 0);
	scale = width / simulator.gridWidth;
    }
    
    //Thanks this guy https://www.youtube.com/watch?v=ZQ8qtAizis4 javidx9 for the zooming and panning
    public void changeZoom(int n, Point2D mouse) {
	Point2D beforeZoom = screenToSim(mouse);
	scale *= 1 + n * 0.05;
	scale = Math.max(200 / (float)simulator.gridWidth, Math.min(100, scale));
	Point2D afterZoom = screenToSim(mouse);
	
	offset.setLocation(
		offset.getX() + beforeZoom.getX() - afterZoom.getX(),
		offset.getY() + beforeZoom.getY() - afterZoom.getY());
    }
    
    public Point2D screenToSim(Point2D screen) {
	return new Point2D.Double(
		 screen.getX() / scale + offset.getX(), 
		 screen.getY() / scale + offset.getY()
	);
    }
    
    private Point2D simToScreen(Point2D world) {
	return new Point2D.Double(
		 (world.getX() - offset.getX()) * scale, 
		 (world.getY() - offset.getY()) * scale
	);
    }
    
    public void pan(Point2D dMouse) {
	offset.setLocation(
		offset.getX() - dMouse.getX() / scale,
		offset.getY() - dMouse.getY() / scale);
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
	
	g.setColor(Color.white);
	g.fillRect(0, 0, width, height);
	
	Color[] cols = new Color[simulator.automata.getNumberOfStates()];
	for(int i = 0; i < cols.length; i++)
	    cols[i] = MiscUtil.colorFromState(i, cols.length);
	
	int startRowIndex = Math.max(0,(int)offset.getY());
	int startColIndex = Math.max(0,(int)offset.getX());
	
	Point2D scrBotRight = screenToSim(new Point2D.Double(width, height));
	
	int endRowIndex = Math.min(simulator.gridHeight, (int)scrBotRight.getY() + 1);
	int endColIndex = Math.min(simulator.gridHeight, (int)scrBotRight.getX() + 1);
	
	for (int i = startRowIndex; i < endRowIndex; i++) {
	    for (int j = startColIndex; j < endColIndex; j++) {

		g.setColor(cols[simulator.grid[i][j]]);
		Point2D topLeft =  simToScreen(new Point2D.Double(j, i));
		g.fillRect((int)topLeft.getX(), (int)topLeft.getY(), 
			   (int)scale + 1, (int)scale + 1);
	    }
	}
    }
    
    public void highlightCell(Graphics2D g, Point2D cellPos) {
	
	if( cellPos.getX() < 0 || cellPos.getY() < 0 || 
	    cellPos.getX() > simulator.gridWidth - 1 ||
	    cellPos.getY() > simulator.gridHeight - 1 )return;
	
	Point2D simCord =  simToScreen(
		new Point2D.Double((int)cellPos.getX(), (int)cellPos.getY()));
	
	g.setStroke(new BasicStroke(scale / 7));
	g.setColor(Color.black);
	g.drawRect((int)simCord.getX(), (int)simCord.getY(), 
			   (int)scale + 1, (int)scale + 1);
    }
}
