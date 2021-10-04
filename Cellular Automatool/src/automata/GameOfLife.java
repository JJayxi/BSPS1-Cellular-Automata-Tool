package automata;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameOfLife {
    
    private boolean[][] grid;
    private int gridWidth, gridHeight;
    
    public GameOfLife(int gridWidth, int gridHeight) {
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	grid = new boolean[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		grid[i][j] = Math.random() < .5;
	    }
    }
    
    public void update() {
	boolean[][] newGrid = new boolean[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		newGrid[i][j] = nextState(j, i);
	    }
	grid = newGrid;
    }
    
    private boolean nextState(int x, int y) {
	int[] count = new int[2];
	if(x - 1 >= 0){		    count[grid[y    ][x - 1] ? 1 : 0]++;
	    if(y - 1 >= 0)	    count[grid[y - 1][x - 1] ? 1 : 0]++;
	    if(y + 1 < gridHeight)  count[grid[y + 1][x - 1] ? 1 : 0]++;
	}
	if(x + 1 < gridWidth){      count[grid[y    ][x + 1] ? 1 : 0]++;
	    if(y - 1 >= 0)	    count[grid[y - 1][x + 1] ? 1 : 0]++;
	    if(y + 1 < gridHeight)  count[grid[y + 1][x + 1] ? 1 : 0]++;
	}

	if(y - 1 >= 0)		    count[grid[y - 1][x    ] ? 1 : 0]++;
	if(y + 1 < gridHeight)	    count[grid[y + 1][x    ] ? 1 : 0]++;
	
	if(grid[y][x]) {
	    if(count[1] < 2) return false;
	    if(count[1] > 3) return false;
	    return true;
	}
	
	return count[1] == 3;
    }
    
    public void draw(Graphics2D g, int width, int height) {
	float dx = height / gridHeight;
	float dy = width /  gridWidth;
	
	for (int i = 0; i < gridHeight; i++) {
	    for (int j = 0; j < gridWidth; j++) {
		if(grid[i][j])
		    g.setColor(Color.black);
		else
		    g.setColor(Color.white);
		g.fillRect((int)(i * dx), (int)(j * dy), (int)dx, (int)dy);
	    }
	}
    }
}