package automata.stats;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import util.MiscUtil;

public class Stats {
    private ArrayList<Integer> activity = new ArrayList<>();
    private ArrayList<int[]> cellCounting = new ArrayList<>();
    
    private final int gridWidth, gridHeight;
    private final int numberOfStates;
    
    public Stats(int gridWidth, int gridHeight, int numberOfStates) {
	this.gridWidth = gridWidth;
	this.gridHeight = gridHeight;
	this.numberOfStates = numberOfStates;
    }
    
    public void addStepValues(int cellChange, int[] cellCount) {
	if(cellChange > maxActivity)maxActivity = cellChange;
	activity.add(cellChange);
	cellCounting.add(cellCount);
    }
    
    
    private int maxActivity = 0;
    public void showActivity(Graphics2D g, int width, int height) {
	g.setColor(Color.white);
	g.fillRect(0, 0, width, height);
	g.setColor(Color.black);
	float dw = (float) width / activity.size();
	for(int i = 0; i < activity.size() - 1; i++) {
	    int h1 = height - (int)((float)activity.get(i) / maxActivity * height);
	    int h2 = height - (int)((float)activity.get(i + 1) / maxActivity * height);
	    g.drawLine((int)(dw * i), h1,(int)(dw * (i + 1)), h2);
	    
	}
    }
    public void showCellCount(Graphics2D g, int width, int height) {
	    int[] polygonsX = new int[activity.size() * 2];
	    int[][] polygonsY = new int[numberOfStates][activity.size() * 2];
	    float dw = (float) width / activity.size();
	    
	    g.setColor(Color.white);
	    g.fillRect(0, 0, width, height);
	    
	    for(int i = 0; i < cellCounting.size(); i++) {
		polygonsX[i] = polygonsX[polygonsX.length - i - 1] = (int)(i * dw);
		
		float h = 0;
		for(int state = 0; state < polygonsY.length; state++) {
		    polygonsY[state][i] = (int)(h * height);
		    h += cellCounting.get(i)[state] / ((float)gridWidth * gridHeight);
		    polygonsY[state][polygonsX.length - 1 - i] = (int)(h * height);
		}
	    }
	    
	    for(int state = 0; state < polygonsY.length; state++) {
		g.setColor(MiscUtil.colorFromState(state, numberOfStates));
		g.fillPolygon(polygonsX, polygonsY[state], activity.size() * 2);
	    }
	    
    }
}