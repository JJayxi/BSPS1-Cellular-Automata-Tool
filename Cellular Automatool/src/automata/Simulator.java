package automata;

import automata.stats.Stats;

public class Simulator {
    protected int[][] grid;
    protected int gridWidth, gridHeight;
    public Stats stats;
    
    GameOfLife gameOfLife = new GameOfLife();
    
    public Simulator(int gridWidth, int gridHeight) {
	stats = new Stats();
	
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	grid = new int[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		grid[i][j] = Math.random() < .5 ? 0 : 1;
	    }
    }
    
    public void update() {
	int[] cellCount = new int[2];
	int activity = 0;
	int[][] newGrid = new int[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		cellCount[grid[j][i]]++;
		newGrid[i][j] = nextState(j, i);
		if(grid[i][j] != newGrid[i][j])activity++;
		
	    }
	grid = newGrid;
	stats.addStepValues(activity, cellCount);
    }
    
    private int nextState(int x, int y) {
	int[] count = new int[2];
	if(x - 1 >= 0){		    count[grid[y    ][x - 1]]++;
	    if(y - 1 >= 0)	    count[grid[y - 1][x - 1]]++;
	    if(y + 1 < gridHeight)  count[grid[y + 1][x - 1]]++;
	}
	if(x + 1 < gridWidth){      count[grid[y    ][x + 1]]++;
	    if(y - 1 >= 0)	    count[grid[y - 1][x + 1]]++;
	    if(y + 1 < gridHeight)  count[grid[y + 1][x + 1]]++;
	}

	if(y - 1 >= 0)		    count[grid[y - 1][x    ]]++;
	if(y + 1 < gridHeight)	    count[grid[y + 1][x    ]]++;
	
	return gameOfLife.evaluate(count, grid[y][x]);
    }
}