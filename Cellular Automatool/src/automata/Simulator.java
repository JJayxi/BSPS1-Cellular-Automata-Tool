package automata;

import automata.presets.*;
import automata.stats.Stats;

public class Simulator {
    
    
    protected int[][] grid;
    protected int gridWidth, gridHeight;
    public Stats stats;
    
    //Automaton automaton = new GameOfLife();
    Automata automaton = new RockPaperScissors();
    
    /**
     * @param gridWidth number of columns in the grid of the running simulation
     * @param gridHeight number of rows in the grid of the running simulation
     * @param automaton automaton that will run the simulation
     */
    public Simulator(int gridWidth, int gridHeight, Automata automaton) {
	
	this.automaton = automaton;
	
	stats = new Stats(gridWidth, gridHeight, automaton.getNumberOfStates());
	
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	randomizeGrid();
    }
    
    /**
     * sets the states of all the cells in the grid to a random possible state
     */
    public void randomizeGrid() {
	grid = new int[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		grid[i][j] = (int)(Math.random() * automaton.getNumberOfStates());
	    }
    }
    
    /**
     * steps the simulation into the next timestep. The local rule is calculated
     * for every cell, then the calculated state is applied to the cell. \n
     * The number of cells in each state is counted, and so is the number of cells
     * that change state. Those value are then added in the Simulator.stats to be tracked. 
     */
    public void update() {
	int[] cellCount = new int[automaton.getNumberOfStates()];
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
    
    /**
     * Calculates the next state of a specific cell in the grid
     * @param x column if that cell
     * @param y row of that cell
     * @return the state that this cell will have in the next time step by
     * applying the local rule
     */
    private int nextState(int x, int y) {
	int[] count = new int[automaton.getNumberOfStates()];
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
	
	return automaton.evaluate(count, grid[y][x]);
    }
    
    /**
     * @return returns the object which contains the values of the number of cell
     * in each state on each time step and the activity (number of cells changed). 
     */
    public Stats getStats() {
	return stats;
    }
    
}