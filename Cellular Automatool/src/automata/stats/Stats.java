package automata.stats;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Stats {
    private ArrayList<Integer> activity = new ArrayList<>();
    private ArrayList<int[]> cellCounting = new ArrayList<>();
    
    private final int gridWidth, gridHeight;
    
    public Stats(int gridWidth, int gridHeight) {
	this.gridWidth = gridWidth;
	this.gridHeight = gridHeight;
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
	    int[][] polygonsX = new int[2][activity.size() + 2];
	    int[][] polygonsY = new int[2][activity.size() + 2];
	    
	    
    }
}